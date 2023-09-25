import React, { useState, useEffect } from "react";
// import "./DisplayEmployee.css";
import axios from "axios";
// import AssignProject from "./AssignProject";
import { Link } from "react-router-dom";
import Skills from "../../DropDown/Skills";
import MultiSelectDropdown from "../../DropDown/MultiDropDown";

function EmployeeTab() {
  const [employees, setEmployees] = useState([]);
  const [assignProject, setAssignProject] = useState(false);
  const [managerNames, setManagerNames] = useState({});
  const [selectedSkills, setSelectedSkills] = useState([]);
  const [skills, setSkills] = useState([]);
  const [check, setCheck] = useState(false);

  //const [check,setCheck]=useState(false);

  //const skillsList = props.skills;
  // const check=true;

  useEffect(() => {
    getAllEmployees();
  }, []);

  function reverseDateFormat(inputDate) {
    // Split the input date using the '-' separator
    const dateParts = inputDate.split("-");
    // Check if the input has three parts (year, month, day)
    if (dateParts.length === 3) {
      // Reverse the parts and join them with '-' separator
      const reversedDate =
        dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
      return reversedDate;
    } else {
      // Handle invalid input format
      return "Invalid Date Format";
    }
  }
  const getAllEmployees = async () => {
    try {
      console.log("called");
      // console.log(props.skills);
      const response = await axios.get("http://localhost:8081/all/EMPLOYEE");
      // const response = await axios.get(
      //   http://localhost:8081/all/employees/skills?skills=React&isCheck=false
      //   // `http://localhost:8081/all/employees/skills?skills=${skillsList}&isCheck=${check}`
      // );
      console.log("response", response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };
  //filter unassigned
  const handleSkillClick = () => {
    console.log(skills);
    //setIsClick(true);
    console.log(check);
    //setActiveTab("");
    getSkilledEmployee(skills, check);
    //  {<EmployeeTab skills={skills} isCheck={check} />}
  };
  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const handleCheckChange = () => {
    setCheck(!check);
  };
  const getSkilledEmployee = async (skills, check) => {
    try {
      const response = await axios.get(
        `http://localhost:8081/all/employees/skills?skills=${skills}&isCheck=${check}`
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  <div>
    <label>Search Skills:</label>
    <div>
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
          {
            //setIsClick(false);
          }
        }}
        placeholder="Select Skills"
        //onBlur={handleSkillBlur}
        //className="skillsInput"
      />

      <label for="myCheckbox">Unassigned Employee:</label>
      <input
        type="checkbox"
        name="myCheckbox"
        value="option1"
        onChange={handleCheckChange}
        checked={check}
      />
      <button onClick={handleSkillClick}>Search Employee</button>
    </div>
  </div>;
  return (
    <>
      <div>
        <label>Search Skills:</label>
        <div>
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
            placeholder="Select Skills"
          />

          <label for="myCheckbox">Unassigned Employee:</label>
          <input
            type="checkbox"
            name="myCheckbox"
            value="option1"
            onChange={handleCheckChange}
            checked={check}
          />
          <button onClick={handleSkillClick}>Search Employee</button>
        </div>
      </div>
      <div className="container">

        <div className="card-container">
          {employees.map((employee) => (
            <div className="card" key={employee.id}>
              <div className="column">
                <h2 className="empName">{employee.name}</h2>
                <sup className="designation">{employee.designation}</sup>
                <p>
                  <span style={{ fontWeight: "bold" }}>Project Name : </span>{" "}
                  {employee.project ? employee.project : "N/A"}{" "}
                </p>
                <p>
                  <span style={{ fontWeight: "bold" }}>Manager : </span>{" "}
                  {employee.manager}
                </p>
                <p>
                  <span style={{ fontWeight: "bold" }}>Contact : </span>
                  {employee.phoneNo}
                </p>
                <p>
                  <span style={{ fontWeight: "bold" }}>Email : </span>{" "}
                  {employee.email}
                </p>
                <p>
                  <span style={{ fontWeight: "bold" }}>Skills : </span>{" "}
                  {employee.skills.join(",")}
                </p>
              </div>
              <br />
              <div className="columnRight">
                <p style={{ fontSize: "14px" }}>
                  <span style={{ fontWeight: "bold", marginTop: "50px" }}>
                    Employee ID :
                  </span>{" "}
                  {employee.empId}
                </p>
                <br />
                <div className="columnBottom">
                  <p style={{ fontSize: "14px" }}>
                    <span style={{ fontWeight: "bold" }}>DOB : </span>
                    {reverseDateFormat(employee.dob)}
                  </p>
                  <p style={{ fontSize: "14px" }}>
                    <span style={{ fontWeight: "bold" }}>DOJ: </span>
                    {reverseDateFormat(employee.doj)}
                  </p>
                  <p style={{ fontSize: "14px" }}>
                    <span style={{ fontWeight: "bold" }}>Location :</span>{" "}
                    {employee.location}
                  </p>
                  <div style={{ marginTop: "1rem" }}>
                    {!employee.project && (
                      <Link
                        to={`/requestResource/${employee.id}`}
                        className="assignProjectbtn"
                        return
                        employee={employee}
                      >
                        Request Resource
                      </Link>
                    )}
                  </div>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default EmployeeTab;
