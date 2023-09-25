import React, {useState, useEffect} from 'react'
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import MultiSelectDropdown from '../../../component/MultiSelectDropdown/MultiSelectDropDown';
import Skills from '../../../component/Data/skills';



const ManagerDisplayEmployee = () => {
    const [employees, setEmployees] = useState([]);
    const [managerId_usestate, setmanagerId_usestate] = useState("");
    const navigate = useNavigate();
    const email = localStorage.getItem("email")
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
        response.data.forEach((employee)=> {
          IsRequested(employee)
        });
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
    const IsRequested = async (employeeObject) => {
      try {
        const response = await axios.post(
          "http://localhost:8080/user/employee/isRequested",
          {
            employeeId: employeeObject.id,
            managerEmail: email,
          }
        );
         const isRequested = response.data;
         
         setEmployees((prevEmployees) =>
           prevEmployees.map((employee) =>
             employee.id === employeeObject.id
               ? { ...employee, isRequested: isRequested }
               : employee
           )
         );
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };
  
    return (
      
      <div >
        <div>
        <label>Search Skills:</label>
        <div>
          <MultiSelectDropdown
            options={Skills.map((skill) => ({
              value: skill,
              label: skill,
            }))}
            selectedOptions={selectedSkills.map((skill) => ({
              value: skill,
              label: skill,
            }))}
            onChange={(event) => {
              {
                handleSkillChange(event);
              }
              
            }}
            placeholder="Select Skills"
          />

          <label for="myCheckbox">Unassigned Employee:</label>
          <input
            type="checkbox"
            name="myCheckbox"
            value="option1"
            onChange={handleCheckChange}
            checked={check}
          />
          <button onClick={handleSkillClick}>Search Employee</button>
        </div>
      </div>
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
              <p><span className="highlight-span">Skills : </span>{employee.skills.join(", ")}</p>
              
              </div>
              <div className="column">
              <p className="emp-id" style={{fontSize:"15px"}}><span className="highlight-span">Employee id : </span>{employee.userId}</p>
              <br></br>
              <p><span className="highlight-span">DOB : </span>{employee.dob}</p>
              <p><span className="highlight-span">DOJ: </span>{employee.doj}</p>
              <p><span className="highlight-span">Location : </span>{employee.location}</p>
              
             {employee.projectName === "N/A" && 
              <p>
                { employee.isRequested ? (<button disabled>Requested</button>) :
                    (
                      <button className="MD-btn" onClick ={() => {navigate(`/requestResource/${employee.id}`)}}>Request Resource </button>
                    )
                }
              </p>
             }
    
              </div>
              
  
            </div>
          ))}
        </div>
      </div>
    );
}

export default ManagerDisplayEmployee