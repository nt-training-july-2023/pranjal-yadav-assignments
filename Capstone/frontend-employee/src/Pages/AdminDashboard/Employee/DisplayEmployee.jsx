import React, { useEffect, useState } from "react";
import "../../../style/DIsplay.css";
import AdminService from '../../../service/AdminService'
import EmployeeCard from "../../../component/SingleEmployeeCard/EmployeeCard";

const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);

  const [isPopupOpen,setIsPopupOpen] = useState(false);


  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    try {
      AdminService.getUserByRole("EMPLOYEE").then((response) =>{
        setEmployees(response.data);
      })
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    <div>
      <div className="card_container final">
        {employees.sort(function (a, b) {
                    return a.name.localeCompare(b.name);
                }).map((employee) => (
         <EmployeeCard employee={employee}/>
        ))}
      </div>
    </div>
  );
};

export default DisplayEmployee;



