import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import MultiSelectDropdown from "../MultiSelectDropDown";
import Skills from "../../list/skills";
import '../EmployeeComponents/UpdateSkills.css'

const UpdateSkills = () => {
  const [skills, setSkills] = useState([]);
  const [employeeDetails, setEmployeeDetails] = useState([]);
  const { id } = useParams();
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [updateSkillsError, setUpdateSkillsError] = useState("");
  const [fetchData, setFetchData] = useState(false);
  const navigate = useNavigate();

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
    getEmployee();
  }, []);
  const getEmployee = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/user/getUserById/${id}`
      );
      setEmployeeDetails(response.data);
      console.log(employeeDetails);
      setTimeout(() => {
        setFetchData(true);
      }, 200);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    console.log(employeeDetails.skills);
    if (employeeDetails.skills) {
      setSelectedSkills(employeeDetails.skills);
    }
  }, [employeeDetails]);
  
  const handleUpdate = async () => {
    ValidateSkill();
    if (updateSkillsError) {
      return;
    }
    if(skills.length ===0){
      return;
    }
    try {
      const response = await axios.put(
        `http://localhost:8080/user/${id}/skill`,
        {
          skills: skills,
        }
      );

      console.log("Employee updated:", response.data);
      navigate("/EmployeeDashboard");
    } catch (error) {
      console.error("Error updating employee:", error);
    }
  };
  return (
    <>
      <div style={{marginTop: "150px"}} className="container-assign-project">
        <h3> Update Skills for</h3>
        <h3 style={{ fontWeight: "bold"}}>
          {employeeDetails.name}
        </h3>
        <div className="assign-container">
          
          {fetchData && (
            <MultiSelectDropdown
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
          <button className="button-submit" onClick={handleUpdate}>
            Submit
          </button>
          <button
            className="button-cancel"
            onClick={() => {
              navigate("/EmployeeDashboard");
            }}
          >
            Cancel
          </button>
        </div>
      </div>
    </>
  );
};

export default UpdateSkills;