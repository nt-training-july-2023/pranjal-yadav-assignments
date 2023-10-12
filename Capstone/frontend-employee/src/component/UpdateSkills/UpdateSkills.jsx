import React, { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import MultiSelectDropdown from "../MultiSelectDropdown/MultiSelectDropDown";
import Skills from "../Data/skills";
import "./UpdateSkills.css";
import AdminService from "../../service/AdminService";
import CustomButton from "../CustomButton";

const UpdateSkills = () => {
  const [skills, setSkills] = useState([]);
  const [employeeDetails, setEmployeeDetails] = useState([]);
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [updateSkillsError, setUpdateSkillsError] = useState("");
  const [fetchData, setFetchData] = useState(false);
  const navigate = useNavigate();
  const location = useLocation();
  const state = location.state;

  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const ValidateSkill = () => {
    if (skills.length === 0) {
      setUpdateSkillsError("Select atleast one skill");
    } else {
      setUpdateSkillsError("");
    }
  };

  useEffect(() => {
    if (state.empSkills) {
      setSelectedSkills(state.empSkills);
      setFetchData(true);
    }
  }, [employeeDetails]);

  const handleUpdate = async () => {
    ValidateSkill();
    if (updateSkillsError) {
      return;
    }
    if (skills.length === 0) {
      return;
    }
    try {
      AdminService.updateSkills(state.empId, {
        skills: skills,
      }).then((response) => {
        navigate("/EmployeeDashboard");
      });
    } catch (error) {
      console.error("Error updating employee:", error);
    }
  };
  return (
    <>
      <div style={{ marginTop: "150px" }} className="container_assign_project">
        <h3> Update Skills for</h3>
        <h3 style={{ fontWeight: "bold" }}>{state.empName}</h3>
        <div className="assign-container">
          {fetchData && (
            <MultiSelectDropdown
              className="multi_update_skills"
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
            />
          )}
        </div>
        {updateSkillsError && (
          <span style={{ color: "red" }}>{updateSkillsError}</span>
        )}
        <div className="buttons">
          <CustomButton
            text="Submit"
            onClick={handleUpdate}
            style="button-submit"
          />
          <CustomButton
            text="Cancel"
            onClick={() => {
              navigate("/EmployeeDashboard");
            }}
            style="button-cancel"
          />
        </div>
      </div>
    </>
  );
};

export default UpdateSkills;
