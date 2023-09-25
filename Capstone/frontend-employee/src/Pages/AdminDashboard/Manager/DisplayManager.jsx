import React, { useEffect, useState } from "react";
import axios from "axios";
import '../../../style/DIsplay.css';
import ManagerCard from "../../../component/SingleManagerCard/ManagerCard";

const DisplayManager = () => {
  const [employees, setEmployees] = useState([]);
  const [projects, setProjects] = useState([]);
  const [managerProjects, setManagerProjects] = useState({});
  const [selectedSkills, setSelectedSkills] = useState({});

  useEffect(() => {
    getAllManagers();
    // getAllProjects();
  }, []);



  const getAllManagers = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/user/all/MANAGER"
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    
    <div >
       
      <div className="card-container">
        {employees.map((manager) => {
         return <ManagerCard manager={manager} />
})}
      </div>
    </div>
  );
};

export default DisplayManager;
