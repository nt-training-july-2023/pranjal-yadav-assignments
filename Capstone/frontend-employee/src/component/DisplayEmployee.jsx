import React, { useEffect, useState } from "react";
import axios from "axios";
import '../style/DIsplay.css';
import { Link } from "react-router-dom";


const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [doj, setdoj] = useState("");
  const [projects, setProjects] = useState([]);
  const [managerName, setManagerName]  = useState("");
  const [managerId_usestate, setmanagerId_usestate] = useState("");
  const [managerNames, setManagerNames] = useState({});

  useEffect(() => {
    getAllEmployees();
  }, []);

  useEffect(() => {
    getManagerById();
  }, [employees]);

  // const getManagerById = async () =>{
  //   try{
  //     const response = await axios.get(`http://localhost:8080/user/getManagerById/${employees.managerId}`)
  //     console.log(response.data)
  //     setManagerName(response.data);
  //     return {id : employee.id, managerName : response.data.name}
  //   }
  //   catch(error){
  //     console.log(error);
  //   }
  // }
  async function getManagerById() {
    const managerNamePromises = employees.map(async (employee) => {
      try {
        const res = await axios.get(
          `http://localhost:8080/user/getEmployee/${employee.managerId}`
        );
        return { id: employee.id, managerName: res.data.name };
      } catch (error) {
        console.log(error);
        return { id: employee.id, managerName: "Error fetching name" };
      }
    });
    const managerNameResults = await Promise.all(managerNamePromises);
    const managerNameMap = {};
    managerNameResults.forEach((result) => {
      managerNameMap[result.id] = result.managerName;
    });
    console.log("manager name map", managerNameMap);
    setManagerNames(managerNameMap);
  }

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
          <div className="card" key={employee.userId}>
            <div className="column">
              <div className="name-designation">
              <h2>{employee.name}</h2>
            <p >{employee.designation}</p>
              </div>
            
            <p><span className="highlight-span">Project Name : </span> {employee.project}</p>
            <p><span className="highlight-span">Manager :</span>{managerNames[employee.id]}</p>
            {/* <p>Manager : Ankita Sharma</p> */}
            <p><span className="highlight-span">Contact : </span>{employee.contactNo}</p>
            <p><span className="highlight-span">Email : </span>{employee.email}</p>
            {!employee.project && (
                
                  <button className="assign-button">Assign Project</button>
                
              )}
            </div>
            <div className="column">
            <p className="emp-id" style={{fontSize:"15px"}}><span className="highlight-span">Employee id : </span>{employee.userId}</p>
            <br></br>
            <p><span className="highlight-span">DOB : </span>{employee.dob}</p>
            <p><span className="highlight-span">DOJ: </span>{employee.doj}</p>
            <p><span className="highlight-span">Location : </span>{employee.location}</p>
            {/* <p>Skills: {(employee.skills) ? (employee.skills.replace(/[\[\]'+/g,'') ): "NA" } </p> */}
            {/* <p style={{marginTop:"1rem"}}> <span className="highlight-span">Skills :  </span> {(employee.skills)?(employee.skills.join(",")):"NA"}</p> */}
            </div>
            

          </div>
        ))}
      </div>
    </div>
  );
};

export default DisplayEmployee;
