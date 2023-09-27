import React, { useEffect, useState } from "react";
// import '../../style/MyProfile.css'
// import "../EmployeeDashBoard/MyProfile.css"
import '../../EmployeeDashboard/MyProfile.css'
import { Link, useNavigate } from "react-router-dom";

import axios from "axios";

const MyProfile = () => {
  useEffect(() => {
    getEmployee();
  }, []);
  const navigate = useNavigate()
  const [employee, setEmployee] = useState([]);
  const [managerName, setManagerName] = useState("");
  const [empName, setEmpName] = useState("")

  const getEmployee = async () => {
    const empEmail = localStorage.getItem("email");
    const id = localStorage.getItem("id")
    console.log(empEmail);
    const response = await axios.get(
      `http://localhost:8080/user/getUserById/${id}`
    );
    setEmployee(response.data);
    setEmpName(employee.name)
  };
  return (
    <div className="container">
      <h2 style={{marginLeft : "38rem", marginTop : "23px"}}>Welcome {localStorage.getItem("name")}</h2>
    <div className="main-profile">
      {employee ? (
        <div >
          <div className="MyProfile_form">
          <div className="my_details_container">
            <div className="column_my_details">
            {/* <h3  style={{marginBottom :"0rem"}}>Welcome, {employee.name}</h3> */}
              <strong>Name</strong>
              <p className="field_input">{employee.name}</p>
              <strong>Email</strong>
              <p className="field_input">{employee.email}</p>

              <strong>DOB</strong>
              <p className="field_input">{employee.dob}</p>

              <strong >Skills</strong>
              <p className="field_input_skills">{employee.skills ? employee.skills.join(",") : "N/A"}</p>
              <p><button className='btn' onClick={()=>{navigate("/updateSkills", {state: {empId: employee.id, empName: employee.name,empSkills: employee.skills}})}}>Update Skills</button></p>
          
            </div>

            <div className="column-my-details">
            
              <strong>Contact No</strong>
              <p className="field_input">{employee.contactNo}</p>
              <strong>Project Name</strong>
              <p className="field_input">{employee.projectName}</p>

              <strong>Manager</strong>
              <p className="field_input">{employee.managerName}</p>

              <strong>DOJ</strong>
              <p className="field_input">{employee.doj}</p>

              <strong>Location</strong>
              <p className="field_input">{employee.location}</p>
            </div>
          </div>
        </div>
        </div>
      ) : (
        <p>Loading employee details...</p>
      )}
     
    </div>
    </div>
  );
};

export default MyProfile;
