import React, { useEffect, useState } from "react";
import {Link} from 'react-router-dom'
import EmployeeService from "../services/EmployeeService";

export const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  //mounting
  useEffect(() => {
    EmployeeService.getAllEmployees().then((response)=>{
      setEmployees(response.data);
      console.log(response.data);
    }).catch((error)=>{
      console.log(error);
    })
  }, []);
  
  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <Link to="/add-employee" className ="btn btn-primary mb-2">Add Employee</Link>
      <table className="table table-bordered ">
        <thead>
          <th>Employee Id</th>
          <th>Employee First Name</th>
          <th>Employee last name</th>
          <th>Employee email id</th>
          <th>Actions</th>
        </thead>

        <tbody>
            {
                employees.map(
                    employee => 
                    <tr key={employee.id}>
                        <td> {employee.id} </td>
                        <td> {employee.firstName} </td>
                        <td> {employee.lastName} </td>
                        <td> {employee.email} </td>
                        <td>
                          <Link className="btn btn-info" to={'/edit-employees/${employee.id}'}>Update</Link>
                        </td>
                    </tr>
                )
            }
        </tbody>
      </table>
    </div>
  );
};
