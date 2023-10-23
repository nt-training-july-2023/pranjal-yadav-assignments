import React, { useState, useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";
import Skills from "../Data/skills";
import AddProjectService from "../../service/AddProjectService";
import PopUp from "../PopUp/Popup";
import "../../style/DIsplay.css";
import MultiSelectDropDown from "../MultiSelectDropdown/MultiSelectDropDown";
import ProjectService from '../../service/ProjectService'
import CustomButton from "../CustomButton";
import InputComponent from "../Input/InputComponent";

const AddProject = () => {
  const [projectName, setProjectName] = useState("");
  const [description, setDescription] = useState("");
  const [returnManager, setreturnManager] = useState([]);
  const [startDate, setStartDate] = useState("");
  const [skills, setSkills] = useState([]);
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);
  const [managers, setManagers] = useState([]);
  const [managerId, setManagerId] = useState("");
  const [selectedSkills] = useState([]);

  const navigate = useNavigate();

  const fetchManagers = () => {
    AddProjectService.getAllManagers()
      .then((response) => {
        console.log(response);
        setManagers(response.data);
      })
      .catch((error) => {
      });
  };

  const [projectNameError, setProjectNameError] = useState("");
  const [descriptionError, setDescriptionError] = useState("");
  const [managerIdError, setManagerIdError] = useState("");
  const [startDateError, setStartDateError] = useState("");
  const [skillsError, setSkillsError] = useState("");

  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const handleProjectNameBlur = () => {
    if (projectName === "") {
      setProjectNameError("Give project name");
    } else {
      setProjectNameError("");
    }
  };
  const handleManagerIdBlur = () => {
    if (managerId === "") {
      setManagerIdError("Give Manager id");
    } else {
      setManagerIdError("");
    }
  };
  const handleDescriptionBlur = () => {
    if (description === "") {
      setDescriptionError("Give Description");
    } else {
      setDescriptionError("");
    }
  };
  const handleStartDateBlur = () => {
    if (startDate === "") {
      setStartDateError("Give start date");
    } else {
      setStartDateError("");
    }
  };
  const handleSkillsBlur = () => {
    if (skills.length === 0) {
      setSkillsError("Give skills");
    } else {
      setSkillsError("");
    }
  };
  useEffect(() => {
    fetchManagers();
  }, []);
  const saveProject = (e) => {
    e.preventDefault();
    if (
      projectName === "" ||
      returnManager === "" ||
      description === "" ||
      startDate === "" ||
      skills.length === 0
    ) {
      setDescriptionError("Mandatory field");
      setSkillsError("Mandatory field");
      setStartDateError("Mandatory field");
      setManagerIdError("Mandatory field");
      setProjectNameError("Mandatory field");
      setSkillsError("Mandatory Field");
      return;
    }
    const project = {
      projectName,
      description,
      startDate: startDate,
      managerId,
      skills,
    };

    ProjectService.createProject(project)
      .then((response) => {
        setShowPopUp(true);
        setPopUpMessage("Project Added successfully");
        const navigateToDashboard = () => {
          navigate("/adminDashboard");
        };
        setTimeout(navigateToDashboard, 2000);
      })
      .catch((error) => {
        if (error.response.status === 409) {
          setShowPopUp(true);
          setPopUpMessage("This project name already exists");
        }
      });
  };

  return (
    <div className="signup-container">
      <div className="custom-form">
        {showPopUp && (
          <PopUp
            message={popMessage}
            onClose={() => {
              setShowPopUp(false);
            }}
          />
        )}
        <p className="signup_heading">Add project</p>
        <form action="">
          <div className="form-section">
            <div className="column">
              <div className="form-group">
                <label>Project Name</label>
                <InputComponent
                type="text"
                required
                className="input"
                value={projectName}
                onChange={(e) => {
                  setProjectName(e.target.value);
                  setProjectNameError("");
                }}
                onBlur={handleProjectNameBlur}
                />
                <span>{projectNameError}</span>
              </div>

              <div className="form-group">
                <label>Manager</label>
                <select

                  placeholder="Enter Manager"
                  name="manager"
                  className="input-addproject-manager"
                  onChange={(e) => setManagerId(e.target.value)}
                  onBlur={handleManagerIdBlur}
                >
                  <option value="">Select Manager</option>
                  {managers.map((item) => {
                    
                    return (
                      <option key={item.id} value={item.id}>
                        {item.userId} : {item.name} 
                      </option>
                    );
                  })}
                </select>
                <span>{managerIdError}</span>
              </div>
              <div>

              
              <MultiSelectDropDown
                className="skill_addProject"
                options={Skills.map((skill) => ({
                  value: skill,
                  label: skill,
                }))}
                selectedOptions={selectedSkills.map((skill) => ({
                  value: skill,
                  label: skill,
                }))}
                onChange={handleSkillChange}
                placeholder="Select Skills"
                onBlur={handleSkillsBlur}
              />
              <span>{skillsError}</span>
              </div>
              

              <div className="form-group">
                <label>Start Date</label>
                <InputComponent
                type="date"
                className="input "
                value={startDate}
                onChange={(e) => setStartDate(e.target.value)}
                onBlur={handleStartDateBlur}
                />
                <span>{startDateError}</span>
              </div>
              <div className="form-group">
                <label>Description</label>
                <textarea
                  type="textarea"
                  className="input"
                  rows="4"
                  value={description}
                  onChange={(e) => {
                    setDescription(e.target.value);
                    setDescriptionError("");
                  }}
                  onBlur={handleDescriptionBlur}
                />
                <span>{descriptionError}</span>
              </div>
            </div>
          </div>
          <CustomButton style="submit-button addEmp_submit" text={"Add Project"} onClick={(e) => saveProject(e)}/>
          <Link to="/adminDashBoard">Cancel</Link>
        </form>
      </div>
    </div>
  );
};

export default AddProject;
