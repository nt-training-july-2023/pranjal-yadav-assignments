import React, { useEffect, useState } from "react";
import axios from "axios";
import '../style/DIsplay.css';
import { Link, useNavigate } from "react-router-dom";
import AssignProject from "./AssignProject";


const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [doj, setdoj] = useState("");
  const [projects, setProjects] = useState([]);
  const [managerName, setManagerName]  = useState("");
  const [managerId_usestate, setmanagerId_usestate] = useState("");
  const [managerNames, setManagerNames] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/user/all/EMPLOYEE"
      );
      console.log(response.data);
      setEmployees(response.data);
      setmanagerId_usestate(employees.managerId);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    
    <div >
      <div className="card-container">
        {employees.map((employee) => (
          <div className="card" key={employee.id}>
            <div className="column">
              <div className="name-designation">
              <h2>{employee.name}</h2>
            <p >{employee.designation}</p>
              </div>
            
            <p><span className="highlight-span">Project Name : </span> {employee.projectName}</p>
            <p><span className="highlight-span">Manager :</span>{employee.managerName}</p>
            <p><span className="highlight-span">Contact : </span>{employee.contactNo}</p>
            <p><span className="highlight-span">Email : </span>{employee.email}</p>
            
            </div>
            <div className="column">
            <p className="emp-id" style={{fontSize:"15px"}}><span className="highlight-span">Employee id : </span>{employee.userId}</p>
            <br></br>
            <p><span className="highlight-span">DOB : </span>{employee.dob}</p>
            <p><span className="highlight-span">DOJ: </span>{employee.doj}</p>
            <p><span className="highlight-span">Location : </span>{employee.location}</p>
            
            <br />
            {!employee.projectId && (
                
                <Link className="assign-button" to={`/assignProject/${employee.id}`} return employee ={employee}>Assign Project</Link>
              
            )}
            </div>
            

          </div>
        ))}
      </div>
    </div>
  );
};

export default DisplayEmployee;
