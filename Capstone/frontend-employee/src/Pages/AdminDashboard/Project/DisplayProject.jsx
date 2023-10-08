import React, { useEffect, useState } from "react";
import axios from "axios";
import '../../../style/DIsplay.css';
import { Link } from "react-router-dom";
import ProjectPopup from '../../../component/PopUp/ProjectPopUp'
import ProjectService from "../../../service/ProjectService";
import AdminService from "../../../service/AdminService";
import SingleProjectCard from '../../../component/SingleProjectCard'

const DisplayProject = () => {
  const [projects, setProjects] = useState([]);
  const [managerNames, setManagerNames] = useState({});
  const [showPopup, setShowPopup] = useState(false);
  const [selectedDescription, setSelectedDescription] = useState('');


  useEffect(() => {
    getAllProjects();
  }, []);
  useEffect(() => {
    if (projects.length > 0) {
      getManagerNames();
    }
  }, [projects]);

  const getAllProjects = async () => {
    try {
      // const response = await axios.get(
      //   "http://localhost:8080/project/getAllProjects"
      // );
      // console.log(response.data);
      // setProjects(response.data);
      ProjectService.getAllProjects().then((response) =>{
        setProjects(response.data);
      })
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  function reverseDateFormat(inputDate) {
    if (inputDate) {
      const dateParts = inputDate.split("-");
      if (dateParts.length === 3) {
        const reversedDate = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
        return reversedDate;
      } else {
        return "Invalid Date Format";
      }
    } else {
      return "Date is missing or undefined";
    }
  }
  async function getManagerNames() {
    const managerNamePromises = projects.map(async (project) => {
      try {
        const response = await axios.get(
          `http://localhost:8080/user/getEmployeeById/${project.managerId}`
        );
        return { projectId: project.projectId, managerName: response.data.name };
      } catch (error) {
        console.log(error);
        return {
          projectId: project.projectId,
          managerName: "Error fetching name",
        };
      }
    
  });
  const managerNameResults = await Promise.all(managerNamePromises);
  const managerNameMap = {};
  managerNameResults.forEach((result) => {
    // managerNameMap[result.projectId] = result.managerName;

    console.log("Project ID:", result.projectId);
    console.log("Manager Name:", result.managerName);
    managerNameMap[result.projectId] = result.managerName;
  });
  console.log("manager name map", managerNameMap);
  console.log("Projects:", projects);
  console.log("Manager Name Results:", managerNameResults);
  setManagerNames(managerNameMap);
}
const handleReadMoreClick = (description) => {
  setSelectedDescription(description);
  setShowPopup(true);
};
const handlePopupClose = () => {
  setShowPopup(false);
  setSelectedDescription('');
};
  return (
    <div >
     <div className="card_container">
        {projects.map((project) => (
          <SingleProjectCard
            key={project.projectId}
            project={project}
            managerName={managerNames[project.projectId]}
            reverseDateFormat={reverseDateFormat}
            handleReadMoreClick={handleReadMoreClick}
          />
        ))}
      </div>
      {showPopup && (
        <ProjectPopup description={selectedDescription} onClose={handlePopupClose} />
      )}
    </div>
  )
}

export default DisplayProject;