import React, { useEffect, useState } from "react";
import axios from "axios";
import '../../../style/DIsplay.css';
import { Link, useNavigate } from "react-router-dom";
import Skills from "../../../component/Data/skills";
import MultiSelectDropdown from "../../../component/MultiSelectDropdown/MultiSelectDropDown";


const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const [doj, setdoj] = useState("");
  const [projects, setProjects] = useState([]);
  const [managerName, setManagerName]  = useState("");
  const [managerId_usestate, setmanagerId_usestate] = useState("");
  const [managerNames, setManagerNames] = useState({});
  const navigate = useNavigate();
  const [check,setCheck]=useState(false);
  const [skills, setSkills] = useState([]);
  const [selectedSkills, setSelectedSkills] = useState([]);

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
  const getSkilledEmployee = async (skills, check) => {
    try {
      const response = await axios.get(
        `http://localhost:8080/user/employees/skills?skills=${skills}&isCheck=${check}`
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };
  const handleCheckChange = () => {
    setCheck(!check);
  };
  const handleSkillClick = () => {
    console.log(skills);
    console.log(check);
    getSkilledEmployee(skills, check);
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
            <p><span className="highlight-span">Email:</span>{employee.email}</p>
            
            </div>
            <div className="column">
            <p className="emp-id" style={{fontSize:"15px"}}><span className="highlight-span">Employee id : </span>{employee.userId}</p>
            <br></br>
            <p><span className="highlight-span">DOB : </span>{employee.dob}</p>
            <p><span className="highlight-span">DOJ: </span>{employee.doj}</p>
            <p><span className="highlight-span">Location : </span>{employee.location}</p>
            
            <br />
            {
              employee.projectId && <button className="assign-button" onClick={()=> {navigate(`/unassign/${employee.id}`)}}>Unassign</button>
              // employee.projectId && <Link to={`/unassign/${employee.id}`} return employee ={employee} className="assign-button">Unassign</Link>
            }
            {!employee.projectId && 
                <button className="assign-button" onClick={()=> {navigate(`/assignProject/${employee.id}`)}}>Assign project</button>
                // <Link className="assign-button" to={`/assignProject/${employee.id}`} return employee ={employee}>Assign Project</Link>
              
            }
            </div>
            

          </div>
        ))}
      </div>
    </div>
  );
};

export default DisplayEmployee;
