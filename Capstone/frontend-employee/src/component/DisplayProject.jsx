import React, { useEffect, useState } from "react";
import axios from "axios";
import '../style/DIsplay.css';
import { Link } from "react-router-dom";
import ProjectPopup from './ProjectPopUp'

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
      const response = await axios.get(
        "http://localhost:8080/project/getAllProjects"
      );
      console.log(response.data);
      setProjects(response.data);
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
      <div className="card-container">
        {projects.map((project) => (
          <div className="card" key={project.projectid}>
            <div className="column">
            <h2>{project.projectName}</h2>
            {/* <p>Manager : {project.managerId}</p> */}
            <p>
                <span className="highlight-span">Head :</span>
                {managerNames[project.projectId]
                  ? managerNames[project.projectId]
                  : "Loading..."}
              </p>
            <p><span className="highlight-span">Description: </span>
            {project.description.length > 40 ? (
              <p> {project.description.slice(0, 30)}{""} 
              <span
                    style={{color:'blue',textDecorationLine:'underline'}}
                      onClick={() => handleReadMoreClick(project.description)}
                    >
                      <br />
                      Read More
                    </span></p>
            ) : ( <p>{project.description}</p>
            )}
            </p>
            </div>
            <div className="column">
            <br></br>
            <p><span className="highlight-span">Start Date</span> : {reverseDateFormat(project.startDate)}</p>
            <p><span className="highlight-span">Project ID:</span> {project.projectId}</p>
            <p> <span className="highlight-span">Skills: </span>{project.skills.join(" , ")}</p>
            <p> <span className="highlight-span">Team: </span>{project.team.join(" , ")}</p>
            {showPopup && (
        <ProjectPopup description={selectedDescription} onClose={handlePopupClose} />
      )}
            </div>
            

          </div>
        ))}
      </div>
    </div>
  )
}

export default DisplayProject;