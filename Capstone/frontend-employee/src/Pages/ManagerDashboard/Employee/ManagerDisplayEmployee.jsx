import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import MultiSelectDropdown from "../../../component/MultiSelectDropdown/MultiSelectDropDown";
import Skills from "../../../component/Data/skills";
import "../../ManagerDashboard/ManagerDashBoard.css";
import AdminService from "../../../service/AdminService";
import RequestResourceService from "../../../service/RequestResourceService";
import CustomButton from "../../../component/CustomButton";
import EmployeeCard from "../../../component/SingleEmployeeCard/EmployeeCard";

const ManagerDisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [managerId_usestate, setmanagerId_usestate] = useState("");
  const navigate = useNavigate();
  const email = localStorage.getItem("email");
  const [check, setCheck] = useState(false);
  const [skills, setSkills] = useState([]);
  const [showError, setShowError] = useState("");
  const [selectedSkills, setSelectedSkills] = useState([]);
  const id = localStorage.getItem("id");
  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    try {
      AdminService.getUserByRole("EMPLOYEE").then((response) => {
        console.log(response.data);
        setEmployees(response.data);
        response.data.forEach((employee) => {
          IsRequested(employee);
        });
        setmanagerId_usestate(employees.managerId);
      });
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  const getSkilledEmployee = async (skills, check) => {
    if (skills.length == 0 && check == false) {
      setShowError("Select checkbox or select skills");
      return;
    }
    try {
      AdminService.filter(skills, check).then((response) =>{
        console.log(response.data);
        setEmployees(response.data);
      })
     
    } catch (error) {
      console.log(error);
    }
  };
  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const handleCheckChange = () => {
    setCheck(!check);
  };
  const handleSkillClick = () => {
    console.log(skills);
    console.log(check);
    getSkilledEmployee(skills, check);
  };
  const IsRequested = async (employeeObject) => {
    try {
      RequestResourceService.isRequested(employeeObject.id, id).then((response) => {
        const isRequested = response.data;

        setEmployees((prevEmployees) =>
          prevEmployees.map((employee) =>
            employee.id === employeeObject.id
              ? { ...employee, isRequested: isRequested }
              : employee
          )
        );
      });
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    <div>
      <div className="search_manager_skills">
        <div style={{ marginTop: "17px"}}>
          <MultiSelectDropdown
            options={Skills.map((skill) => ({
              value: skill,
              label: skill,
            }))}
            selectedOptions={selectedSkills.map((skill) => ({
              value: skill,
              label: skill,
            }))}
            onChange={(event) => {
              {
                handleSkillChange(event);
              }
            }}
            placeholder="Search Skills"
          />
<div className="search_check_and_button">

<div className="check_box">


          <label for="myCheckbox">Unassigned Employee:</label>
          <input
            type="checkbox"
            name="myCheckbox"
            value="option1"
            onChange={handleCheckChange}
            checked={check}
          />
          </div>
          <CustomButton onClick={handleSkillClick} text={"Search Employee"} style={"search_skills"}/>
          <br />
          <span>{showError}</span>
          </div>
        </div>
      </div>
      <div className="card_container">
      {employees.sort(function (a, b) {
                    return a.name.localeCompare(b.name);
                }).map((employee) => (
         <EmployeeCard employee={employee}/>
        ))}
      </div>
    </div>
  );
};

export default ManagerDisplayEmployee;
