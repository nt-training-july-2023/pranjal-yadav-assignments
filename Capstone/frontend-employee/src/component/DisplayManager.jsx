import React, { useEffect, useState } from "react";
import axios from "axios";
import '../style/DIsplay.css';

const DisplayManager = () => {
  const [employees, setEmployees] = useState([]);
  const [projects, setProjects] = useState([]);
  const [managerProjects, setManagerProjects] = useState({});
  const [selectedSkills, setSelectedSkills] = useState({});

  useEffect(() => {
    getAllManagers();
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
  const getAllManagers = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/user/all/MANAGER"
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleProjectChange = async (employeeId, projectId) => {
    try {
      // Update the selected project for the specific employee
      setManagerProjects((prevManagerProjects) => ({
        ...prevManagerProjects,
        [employeeId]: projectId,
      }));

      // Fetch the skills for the selected project
      const response = await axios.get(
        `http://localhost:8080/project/project/${projectId}`
      );
      const skills = response.data.skills || "NA";

      // Update the selected skills for the specific employee
      setSelectedSkills((prevSelectedSkills) => ({
        ...prevSelectedSkills,
        [employeeId]: skills,
      }));
    } catch (error) {
      console.error("Error fetching project skills:", error);
    }
  };

  return (
    
    <div >
      <div className="card-container">
        {employees.map((employee) => (
          <div className="card" key={employee.userId}>
            <div className="column">
              <div className="name-designation">
              <h2>{employee.name}</h2>
            <p >{employee.designation}</p>
              </div>
            
              <p style={{ marginTop: "1rem" }}>
                Project :
                {/* <span style={{ fontWeight: "bold" }}>Select Project</span>{" "} */}
                <select
                  value={managerProjects[employee.id] || ""}
                  onChange={(e) =>
                    handleProjectChange(employee.id, e.target.value)
                  }
                >
                  <option value="">Select a Project</option>
                  {projects
                    .filter((project) => project.managerID === employee.empId)
                    .map((project) => (
                      <option key={project.projectId} value={project.projectId}>
                        {project.projectName}
                      </option>
                    ))}
                </select>
              </p>
            <p>Manager : {employee.manager}</p>
            <p>Contact : {employee.contactNo}</p>
            <p>Email : {employee.email}</p>
            </div>
            <div className="column">
                <br></br>
            <p style={{fontSize:"15px"}}>Employee id : {employee.userId}</p>
            <br></br>
            <p>DOB : {employee.dob}</p>
            <p>DOJ: {employee.doj}</p>
            <p>Location : {employee.location}</p>
            {/* <p style={{marginTop:"1rem"}}>Skills :   {(employee.skills)?(employee.skills.replace(/[\[\]']+/g,'')):"NA"}</p> */}
            <p style={{ marginTop: "1rem" }}>
                <span style={{ fontWeight: "bold" }}>Skills : </span>{" "}
                {selectedSkills[employee.id]
                  ? selectedSkills[employee.id].replace(/[\[\]']+/g, "")
                  : "NA"}
              </p>
            </div>
            

          </div>
        ))}
      </div>
    </div>
  );
};

export default DisplayManager;
