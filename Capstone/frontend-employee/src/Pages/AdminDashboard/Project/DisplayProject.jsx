import React, { useEffect, useState } from "react";
import axios from "axios";
import '../../../style/DIsplay.css';
import ProjectPopup from '../../../component/PopUp/ProjectPopUp'
import ProjectService from "../../../service/ProjectService";
import SingleProjectCard from "../../../component/SingleProjectCard/SingleProjectCard";

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
        return {
          projectId: project.projectId,
          managerName: "Error fetching name",
        };
      }
    
  });
  const managerNameResults = await Promise.all(managerNamePromises);
  const managerNameMap = {};
  managerNameResults.forEach((result) => {

    managerNameMap[result.projectId] = result.managerName;
  });
 
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
    <div>
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