import React, { useEffect, useState } from "react";
import {useNavigate, useLocation } from "react-router-dom";
import "./AssignProject.css";
import ProjectService from "../../service/ProjectService";
import AdminService from "../../service/AdminService";
import CustomButton from "../CustomButton";

const AssignProject = () => {
  useEffect(() => {
    getAllProjects();
  }, []);

  const [projects, setProjects] = useState([]);
  const [projectId, setProjectId] = useState();
  const [managerId, setManagerId] = useState();
  const navigate = useNavigate();
  const location = useLocation();
  const state = location.state;

  const getAllProjects = async () => {
    try {
      ProjectService.getAllProjects().then((response) => {
        setProjects(response.data);
      });
    } catch (error) {
    }
  };
  const update = async (e) => {
    try {
      AdminService.assignProject(
        state.empId,
        projectId,
        managerId
      ).then((response) => {
        navigate("/adminDashboard");
      });
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
      <div className="assign_project">
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
        <CustomButton onClick={(e) => update(e)} text={"Assign Project"} style="update"/>
        <CustomButton
          onClick={() => navigate("/adminDashBoard")}
          style="close-popup"
          text={"Cancel"}
        />
      </div>
    </div>
  );
};

export default AssignProject;
