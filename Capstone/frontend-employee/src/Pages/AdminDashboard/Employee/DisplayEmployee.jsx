import React, { useEffect, useState } from "react";
import "../../../style/DIsplay.css";
import { Link, useNavigate } from "react-router-dom";
import Popup from "../../../component/PopUp/Popup";
import AdminService from '../../../service/AdminService'
import CustomButton from "../../../component/CustomButton";
import EmployeeCard from "../../../component/SingleEmployeeCard/EmployeeCard";

const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [doj, setdoj] = useState("");
  const [projects, setProjects] = useState([]);
  const [managerName, setManagerName] = useState("");
  const [managerId_usestate, setmanagerId_usestate] = useState("");
  const [managerNames, setManagerNames] = useState({});
  const [isPopupOpen,setIsPopupOpen] = useState(false);
  const navigate = useNavigate();
  const [check, setCheck] = useState(false);
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    try {
      AdminService.getUserByRole("EMPLOYEE").then((response) =>{
        setEmployees(response.data);
      setmanagerId_usestate(employees.managerId);
      })
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const accept = async(employee)=>{

    try{
      AdminService.unassign(employee.id).then((response) =>{
        console.log(employee.name);
        window.location.reload();
        setIsPopupOpen(false)
        console.log(response.data);
        getAllEmployees()
      })
      
    } catch(error){
      console.log("jhvhjsv"+ error);
    }
  }
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



