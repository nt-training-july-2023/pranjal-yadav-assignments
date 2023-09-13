import React, { useEffect, useState } from "react";
import axios from "axios";
import '../style/DIsplay.css';
import { Link } from "react-router-dom";


const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [doj, setdoj] = useState("");
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    getAllEmployees();
  }, []);

  useEffect(() => {
    getAllProjects();
  }, []);
const getAllProjects =async () =>{
  try{
    const response = await axios.get("http://localhost:8080/project/getAllProjects")
    console.log(response.data);
    setProjects(response.data.projectName);
  }catch(error){
    console.log(error);
  }
}
  const getAllEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/user/all/EMPLOYEE"
      );
      console.log(response.data);
      setEmployees(response.data);
      
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const setProjectfunction = ()=>{

  }

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
            
            <p>Project Name : {employee.project}</p>
            <p>Manager : {employee.manager}</p>
            <p>Contact : {employee.contactNo}</p>
            <p>Email : {employee.email}</p>
            </div>
            <div className="column">
                <br></br>
            <p style={{fontSize:"15px"}}>Employee id : {employee.userId}</p>
            <br></br>
            <p>DOB : {employee.dob}</p>
            <p>DOJ: {employee.doj}</p>
            <p>Location : {employee.location}</p>
            {/* <p>Skills: {(employee.skills) ? (employee.skills.replace(/[\[\]'+/g,'') ): "NA" } </p> */}
            <p style={{marginTop:"1rem"}}>Skills :   {(employee.skills)?(employee.skills.join(",")):"NA"}</p>
            </div>
            

          </div>
        ))}
      </div>
    </div>
  );
};

export default DisplayEmployee;
