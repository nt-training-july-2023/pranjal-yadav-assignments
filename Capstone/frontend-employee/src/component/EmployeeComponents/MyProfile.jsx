import React, { useEffect, useState } from "react";
// import '../../style/MyProfile.css'
import "../../style/MyProfile.css";
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
    console.log(empEmail);
    const response = await axios.get(
      `http://localhost:8080/user/email/${empEmail}`
    );
    setEmployee(response.data);
    setEmpName(employee.name)
  };

  const getManager = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8080/user/getEmployee/${employee.managerId}`
      );
      console.log(response.data);
      setManagerName(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div className="main-profile">
      {/* <h2 className="welcom-emp">Welcome {empName}</h2> */}
      {employee ? (
        <div >
          <div className="MyProfile_form">
          <div className="my-details-container">
            <div className="column-my-details">
            <h3 style={{marginBottom:"22px"}}>Welcome, {employee.name}</h3>
              <strong>Name</strong>
              <p className="field_input">{employee.name}</p>
              <strong>Email</strong>
              <p style={{marginBottom:"10px"}} className="field_input">{employee.email}</p>

              <strong>DOB</strong>
              <p className="field_input">{employee.dob}</p>

              <strong>Skills</strong>
              {/* <p className="field_input">{employee.skills.join(", ")}</p> */}
              <p className="field_input">{employee.skills ? employee.skills.join(",") : "N/A"}</p>
              <p><button className='btn' onClick={()=>{navigate(`/updateSkills/${employee.id}`)}}>Update Skills</button></p>
          
            </div>

            <div className="column-my-details">
              <br />
              <br />
              <br />
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
  );
};

export default MyProfile;
