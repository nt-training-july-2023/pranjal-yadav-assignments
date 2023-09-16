import React, { useEffect, useState } from "react";
import axios from "axios";
import "../../style/DIsplay.css";
import { Link } from "react-router-dom";

const EmpDisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [doj, setdoj] = useState("");
  const [projects, setProjects] = useState([]);
  const [manager, setManager] = useState("");

  useEffect(() => {
    getAllEmployees();
  }, []);

  useEffect(() => {
    getAllProjects();
  }, []);
  const getAllProjects = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/project/getAllProjects"
      );
      console.log(response.data);
      setProjects(response.data.projectName);
    } catch (error) {
      console.log(error);
    }
  };
  const getAllEmployees = async () => {
    try {
      const response = await axios.get("http://localhost:8080/user/allUsers");
      console.log(response.data);
      setManager(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };


  return (
    <div>
      <div className="card-container">
        {employees.map((employee) => (
          <div className="card" key={employee.userId}>
            <div className="column">
              <div className="name-designation">
                <h2>{employee.name}</h2>
                <p>{employee.designation}</p>
              </div>

              <p><strong>Manager : </strong>{employee.managerName}</p>
              <p><strong>Contact : </strong>{employee.contactNo}</p>
              <p><strong>Email : </strong>{employee.email}</p>
            </div>
            <div className="column">
              <p style={{ fontSize: "15px" }}>
                <strong>
                Employee id : 
                </strong>
                {employee.userId}
              </p>
              <br></br>
              <p><strong>DOB : </strong>{employee.dob}</p>
              <p><strong>DOJ: </strong>{employee.doj}</p>
              <p><strong>Location : </strong>{employee.location}</p>
              {/* <p>Skills: {(employee.skills) ? (employee.skills.replace(/[\[\]'+/g,'') ): "NA" } </p> */}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EmpDisplayEmployee;
