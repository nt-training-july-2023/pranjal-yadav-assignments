import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import "../RequestResource/RequestResource.css";
import ProjectService from "../../service/ProjectService";
import RequestResourceService from "../../service/RequestResourceService";
import CustomButton from "../CustomButton";
import { validateDescription, validateSelectProject } from "../HandleBlur/HandleBlur";

const RequestResource = () => {
  const navigate = useNavigate();
  const [projectList, setProjectList] = useState([]);
  const [comment, setComment] = useState();
  const [managerID, setManagerID] = useState();
  const [commentError, setCommentError] = useState("");
  const [projectError, setProjectError] = useState("");
  const [projectID, setProjectID] = useState();
  const managerId = localStorage.getItem("id");
  const location = useLocation();
  const state = location.state;
  useEffect(() => {
    getAllProjects();
  }, []);
  const cancel = () => {
    navigate("/managerDashboard");
  };
  const getAllProjects = async () => {
    try {
      ProjectService.getProjectByManagerId(managerId).then((response) => {
        setProjectList(response.data);
      });
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  const handleUpdate = async (e) => {
    e.preventDefault();
    if (projectID === ""|| isNaN(projectID) || managerID == "" || !comment || comment === "") {
      setCommentError("Comment is required");
      setProjectError("Project is required");
      return;

    } else {
      const request = {
        employeeId: state.empId,
        projectId: projectID,
        managerId: managerID,
        comment,
      };
      try {
        RequestResourceService.addRequest(request).then((response) => {
          navigate("/managerDashBoard");
        });
      } catch (error) {
        console.error("Error updating employee:", error);
      }
    }
  };
  const handleSelectChange = (e) => {
    const selectedOption = e.target.options[e.target.selectedIndex];
    const selectedProjectID = e.target.value;
    const selectedManagerID = selectedOption.getAttribute("data-managerid");
    setProjectID(selectedProjectID);
    setManagerID(selectedManagerID);
  };
  const handleCommentBlur = () => {
    if (comment === "" || !comment) {
      setCommentError("Comment is required");
    }
  };

  return (
    <div>
      <div className="req-Resource">
        <div>Request Resource</div>
        <br />
        <div className="req-container">
          <h3 style={{ fontWeight: "bold" }}>{state.empName}</h3>
          <br></br>
          <select
            type="text"
            name="managerId"
            className="project-input-box"
            onChange={handleSelectChange}
          >
            <option value="">Select Project</option>
            {projectList.map((item) => (
              <option
                key={item.projectId}
                value={item.projectId}
                data-managerid={item.managerId}
              >
                {item.projectId} - {item.projectName}
              </option>
            ))}
            <br></br>
          </select>
          <p className="comment_error">{projectError}</p>
          <div className="project-input" style={{ marginTop: "1rem" }}>
            <label>Comment</label>
            <textarea
              value={comment}
              rows="4"
              cols="50"
              maxLength="250"
              className="project-input-box"
              id="project-name"
              onChange={(e) => {
                setComment(e.target.value);
                setCommentError("");
              }}
              onBlur={handleCommentBlur}
            ></textarea>
            <p style={{ color: "red" }} className="comment_error">
              {commentError}
            </p>
          </div>

          <CustomButton
            style="assign-btn"
            text={"Request Resource"}
            onClick={handleUpdate}
          />
          <CustomButton
            style="cancel-assign"
            text={"Cancel"}
            onClick={cancel}
          />
        </div>
      </div>
    </div>
  );
};

export default RequestResource;
