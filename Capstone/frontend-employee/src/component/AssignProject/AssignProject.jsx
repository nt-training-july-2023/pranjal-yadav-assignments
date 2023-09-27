import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams, useNavigate, useLocation } from "react-router-dom";
import './AssignProject.css'

const AssignProject = () => {
  // const { id } = useParams();
  useEffect(() => {
    getAllProjects();
  }, []);

  const [projects, setProjects] = useState([]);
  const [employee, setEmployee] = useState([]);
  const [projectId, setProjectId] = useState();
  const [managerId, setManagerId] = useState();
  const navigate = useNavigate();
  const location = useLocation();
  const state = location.state;

  // const getEmployeeById = async () => {
  //   try {
  //     const response = await axios.get(
  //       `http://localhost:8080/user/getUserById/${state.}`
  //     );
  //     console.log(response.data);
  //     setEmployee(response.data);
  //   } catch (error) {
  //     console.log(error);
  //   }
  // };

  const getAllProjects = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/project/getAllProjects"
      );
      console.log(response.data);
      setProjects(response.data);
    } catch (error) {
      console.log("There is an error");
      console.log(error);
    }
  };
  const update = async (e) => {
    try {
      const response = await axios.put(
        `http://localhost:8080/user/${state.empId}/assignProject`,
        {
          projectId: projectId,
          managerId: managerId,
        }
      );
      console.log(response.data);
      navigate("/adminDashboard")
      
    } catch (error) {
      console.error(error);
    }
  };

  const handleSelectChange = (e) => {
    const selectedOption = e.target.options[e.target.selectedIndex];
    const selectedProjectId = e.target.value;
    const selectedManagerId = selectedOption.getAttribute("data-managerid");
    setProjectId(selectedProjectId);
    setManagerId(selectedManagerId);
  };

  return (
    <div className="center-container-ap">
<div className="assign">
      <label id="label">Assign Project to</label>
      <h3 id="emp-name">{state.empName}</h3>
      <select
        onChange={handleSelectChange}
        type="text"
        id="custom-select"
        placeholder="Enter designation"
        name="location"
      >
        <option value="">Select Project</option>
        {projects.map((project) => {
          return (
            <option
              style={{ color: "black" }}
              className="option-assign"
              key={project.projectId}
              value={project.projectId}
              data-managerid={project.managerId}
            >
              {project.projectId} : {project.projectName}
            </option>
          );
        })}
      </select>
      {/* <span>{designationError}</span> */}
      <button onClick={(e) => update(e)}> Assign Project </button>
    </div>
    </div>
    
  );
};

export default AssignProject;
