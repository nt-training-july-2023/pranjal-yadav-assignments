import React, { useEffect, useState } from "react";
// import '../../style/MyProfile.css'
import "../../style/MyProfile.css";

import axios from "axios";

const MyProfile = () => {
  useEffect(() => {
    getEmployee();
  }, []);
  const [employee, setEmployee] = useState([]);
  const [managerName, setManagerName] = useState("");

  const getEmployee = async () => {
    const empEmail = localStorage.getItem("email");
    console.log(empEmail);
    const response = await axios.get(
      `http://localhost:8080/user/email/${empEmail}`
    );
    setEmployee(response.data);
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
      {employee ? (
        <div >
          <div className="MyProfile_form">
          <div className="my-details-container">
            <div className="column-my-details">
            <h3 style={{marginBottom:"20px"}}>Welcome, {employee.name}</h3>
              <strong>Name</strong>
              <p className="field_input">{employee.name}</p>
              <strong>Email</strong>
              <p className="field_input">{employee.email}</p>

              <strong>DOB</strong>
              <p className="field_input">{employee.dob}</p>

              <strong>Skills</strong>
              <p className="field_input">{employee.skills}</p>
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
  );
};

export default MyProfile;
