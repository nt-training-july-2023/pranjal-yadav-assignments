import React, { useEffect, useState } from "react";
import '../../../style/DIsplay.css';
import ManagerCard from "../../../component/SingleManagerCard/ManagerCard";
import AdminService from "../../../service/AdminService";

const DisplayManager = () => {
  const [employees, setEmployees] = useState([]);


  useEffect(() => {
    getAllManagers();
  }, []);



  const getAllManagers = async () => {
    try {
      AdminService.getUserByRole("MANAGER").then((response) =>{
        setEmployees(response.data)
      })
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    
    <div >
       
      <div className="card_container">
        {employees.map((manager) => {
         return <ManagerCard manager={manager} />
})}
      </div>
    </div>
  );
};

export default DisplayManager;
