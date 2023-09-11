import React, { useEffect, useState } from "react";
import axios from "axios";
import '../style/DIsplay.css';
import { Link } from "react-router-dom";

const DisplayProject = () => {
  const [projects, setProjects] = useState([]);
  useEffect(() => {
    getAllProjects();
  }, []);

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
  return (
    <div >
      <div className="card-container">
        {projects.map((project) => (
          <div className="card" key={project.projectid}>
            <div className="column">
            <h2>{project.projectName}</h2>
            <p>Manager : {project.managerId}</p>
            <p>Description: {project.description}</p>
            </div>
            <div className="column">
            <br></br>
            <p>Start Date : {project.startDate}</p>
            <p>Skills: {project.skills}</p>
            </div>
            

          </div>
        ))}
      </div>
    </div>
  )
}

export default DisplayProject