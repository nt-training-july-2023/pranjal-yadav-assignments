import React, { useEffect, useState } from "react";
import '../../EmployeeDashboard/Organization/EmpDisplayEmployee.css'
import AdminService from "../../../service/AdminService";
import ProjectService from "../../../service/ProjectService";

const EmpDisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
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
      ProjectService.getAllProjects().then((response) =>{
        setProjects(response.data.projectName)
      })
    } catch (error) {
    }
  };
  const getAllEmployees = async () => {
    try {
      AdminService.getAllUsers().then((response) =>{
        setManager(response.data)
        setEmployees(response.data)
      })
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };


  return (
    <div>
      <div className="card_container_employee">
        {employees.sort(function (a, b) {
                    return a.name.localeCompare(b.name);
                }).map((employee) => (
          <div className="card_org" key={employee.userId}>
            <div className="column">
              <div className="name_designation">
                <h2 className="name">{employee.name}</h2>
                <p>{employee.designation}</p>
              </div>

              <p><strong>Manager : </strong>{employee.managerName}</p>
              <p><strong>Contact : </strong>{employee.contactNo}</p>
              <p><strong>Email:</strong> <br />{employee.email}</p>
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
              <p><strong>DOJ : </strong>{employee.doj}</p>
              <p><strong>Location : </strong>{employee.location}</p>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default EmpDisplayEmployee;
