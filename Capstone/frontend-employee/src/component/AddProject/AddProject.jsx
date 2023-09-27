import React, { useState, useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import Skills from "../Data/skills";
import AddProjectService from "../../service/AddProjectService";
import PopUp from "../PopUp/Popup";
import Select from "react-select";
import "../../style/DIsplay.css";
import MultiSelectDropDown from "../MultiSelectDropdown/MultiSelectDropDown";

const AddProject = () => {
  const [projectName, setProjectName] = useState("");
  const [projectId, setProjectId] = useState("");
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
    const managerResponse = AddProjectService.getAllManagers()
      .then((response) => {
        console.log(response);
        setManagers(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  //ERRORS
  const [projectNameError, setProjectNameError] = useState("");
  const [projectIdError, setProjectIdError] = useState("");
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
    // setManagerId(returnManager.id);
    // console.log(managerId);
    // const id =
    const project = {
      projectName,
      description,
      startDate: startDate,
      managerId,
      skills,
    };

    console.log(project);
    AddProjectService.createProject(project)
      .then((response) => {
        setShowPopUp(true);
        setPopUpMessage("Project Added successfully");
        const navigateToDashboard = () => {
          navigate("/adminDashboard");
        };
        setTimeout(navigateToDashboard, 2000);
      })
      .catch((error) => {
        console.log(error);
        if (error.response.status === 409) {
          setShowPopUp(true);
          setPopUpMessage(error.response.data.errorMessage);
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
        <h2 className="title">Add project</h2>
        <form action="">
          <div className="form-section">
            <div className="column">
              <div className="form-group">
                <label>Project Name</label>
                <input
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
                  // value={location}

                  placeholder="Enter Manager"
                  name="manager"
                  className="input-addproject-manager"
                  onChange={(e) => setManagerId(e.target.value)}
                  onBlur={handleManagerIdBlur}
                >
                  <option value="">Select Manager</option>
                  {managers.map((item) => {
                    {
                      console.log(item);
                    }
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
                <input
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
                  // onBlur={handleEmpIDBlur}
                />
                <span>{descriptionError}</span>
              </div>
            </div>
          </div>
          <button
            className="submit-button"
            onClick={(e) => saveProject(e)}
            type="submit"
          >
            Add project
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddProject;
