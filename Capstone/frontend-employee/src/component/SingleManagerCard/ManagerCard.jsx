import axios from 'axios';
import React, { useEffect, useState } from 'react'
import skills from '../Data/skills';
import ProjectService from '../../service/ProjectService';

const ManagerCard = ({manager}) => {

    const [projectList, setProjectList] = useState([]);
    const [selectedProject, setSelectedProject] = useState("");
    const [showDropdown, setShowDropdown] = useState(true);
  const [selectedProjectData, setSelectedProjectData] = useState(null);

    useEffect(() => {
        getAllProjects();
      }, []);
    const getAllProjects =async () =>{
      try{
        // const response = await axios.get(`http://localhost:8080/project/project/${manager.id}`)
        // const projectData = response.data;
        ProjectService.getProjectByManagerId(manager.id).then((response) =>{
          const projectData = response.data;
          if (projectData.length > 0) {
            const firstProject = projectData[0];
            setSelectedProjectData(firstProject); 
            setSelectedProject(firstProject.projectId);
            setShowDropdown(projectData.length > 1);
          }
          setProjectList(response.data);
        })

        
      }catch(error){
        console.log(error);
      }
    }
    const handleProjectChange = async (event) => {
        // setSelectedProject(event.target.value);
        // console.log("Selected project "+selectedProject);
        const selectedProjectId = event.target.value;
        setSelectedProject(selectedProjectId);
        const projectData = projectList.find(
          (project) => project.projectId.toString() === selectedProjectId
        );
        console.log(selectedProjectId);
            console.log(projectData);
        if (projectData) {
          setSelectedProjectData(projectData);
        } else {
          setSelectedProjectData(null);
        }
      };
  return (
    <div>
        <div className="card" key={manager.userId}>
            <div className="column">
              <div className="name-designation" style={{marginBottom :"0.5rem"}}>
              <h2 style={{marginBottom :"3px"}}>{manager.name}</h2>
            <p >{manager.designation}</p>
              </div>
            
              <p style={{ marginTop: "1px" }}>
                <span className="highlight-span">Project :</span>
                <br />
          
                {showDropdown ? (
                <select
                  style={{ marginTop: "0.5rem" }}
                  name="projectName"
                  className="select"
                  onChange={handleProjectChange}
                  value={selectedProject}
                >
                  <option value="" disabled>Select Project</option> 
                  {projectList.map((project) => {
                    return (
                      <option key={project.projectID} value={project.projectId}>
                        {project.projectName}
                      </option>
                    );
                  })}
                </select>
              ) : (
                <p>{selectedProjectData?.projectName}</p>
              )}
              </p>
            <p><span className="highlight-span"> Manager : </span>{manager.managerName}</p>
            <p> <span className='highlight-span'>Contact</span> : {manager.contactNo}</p>
            <p><span className="highlight-span"> Email :</span> <br />{manager.email}</p>
            </div>
            <div className="column">
            <p style={{fontSize:"15px"}}><span className="highlight-span">Employee id :  </span> {manager.userId}</p>
            <br></br> 
            <p><span className="highlight-span"> Location </span>: {manager.location}</p>
            <p style={{ marginTop: "1rem" }}>
                <span className='highlight-span' style={{ fontWeight: "bold" }}>Project Skills : </span>{" "}
                {}
                                {selectedProjectData?.skills.join(", ")}
              </p>
              
              <p><strong>Team : </strong>
              {selectedProjectData?.team.length !== 0
                ? selectedProjectData?.team.join(", ")
                : "N/A"}
            </p>
            </div>
            

          </div>
    </div>
  )
}

export default ManagerCard;