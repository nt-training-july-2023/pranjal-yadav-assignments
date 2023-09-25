import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import './RequestResource.css'

const RequestResource = () => {
  const { id } = useParams();
  const navigate = useNavigate();
    const [projectList,setProjectList] = useState([]);
    const [employeeDetails,setEmployeesDetails] = useState([]);
    const [comment,setComment] = useState();
    const [managerID,setManagerID] = useState();
    const [empId,setEmpId] =useState();
    const [projectID,setProjectID] =useState();
    const email = localStorage.getItem("email");
    useEffect(() => {
        getEmployee();
       getAllProjects();
    },[]);
    const getEmployee = async () => {
        try {
            const resposne = await axios.get(
                `http://localhost:8080/user/getEmployeeById/${id}`
            );
            setEmployeesDetails(resposne.data);
            console.log(resposne.data);
        }catch(error){
        console.log(error);
    }
    }
    const getAllProjects = async () => {
        try {
          const response = await axios.get(
            `http://localhost:8080/project/manager/${email}`
          );
          console.log(response.data);
          setProjectList(response.data);
        } catch (error) {
          console.error("Error fetching data:", error);
        }
      };
      const handleUpdate = async(e) => {
        e.preventDefault();
        const request = {
            employeeId:id,
            projectId:projectID,
            managerId:managerID,
            comment
        }
        try{
          await axios.post("http://localhost:8080/user/request/resource", request);
          navigate("/managerDashBoard")
        }
        catch (error) {
            console.error('Error updating employee:', error);
          }
        };
        const handleSelectChange = (e) => {
          const selectedOption = e.target.options[e.target.selectedIndex];
          const selectedProjectID = e.target.value;
          const selectedManagerID = selectedOption.getAttribute('data-managerid');
          console.log(typeof(selectedManagerID));
          setProjectID(selectedProjectID);
          setManagerID(selectedManagerID);
          console.log(typeof(selectedManagerID,"from handleSelectChange"));
        };

  return (
    <div>
      <div className="req-Resource">
        <div>Request Resource</div>
        <br />
        <div className="req-container">
          <h3 style={{ fontWeight: "bold" }}>{employeeDetails.name}</h3>
          <br></br>
          <select
            type="text"
            name="managerId"
            className="project-input-box"
            onChange={handleSelectChange}
          >
            <option value="">Select Project</option>
            {projectList.map((item) => (
              <option
                key={item.projectId}
                value={item.projectId}
                data-managerid={item.managerId}
              >
                {item.projectId} - {item.projectName}
              </option>
            ))}
            <br></br>
          </select>
          <div className="project-input" style={{ marginTop: "1rem" }}>
            <label>Comment</label>
            <textarea
              value={comment}
              rows="4"
              cols="50"
              maxLength="250"
              className="project-input-box"
              id="project-name"
              onChange={(e) => {
                setComment(e.target.value);
              }}
            ></textarea>
          </div>
          <button type="button" className="assign-btn" onClick={handleUpdate}>
            Request Resource
          </button>
          <button className="cancel-assign"><Link to={"/managerDashboard"} >
            Cancel
          </Link></button>
          
        </div>
      </div>
    </div>
  );
};

export default RequestResource;