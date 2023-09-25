import axios from 'axios';
import React, { useEffect, useState } from 'react'

const ManagerCard = ({manager}) => {

    const [projectList, setProjectList] = useState([]);
    const [selectedProject, setSelectedProject] = useState("");

    useEffect(() => {
        getAllProjects();
      }, []);
    const getAllProjects =async () =>{
      try{
        const response = await axios.get(`http://localhost:8080/project/project/${manager.id}`)
        // console.log(response.data);
        setProjectList(response.data);
      }catch(error){
        console.log(error);
      }
    }
    const handleProjectChange = async (event) => {
        setSelectedProject(event.target.value);
        console.log("Selected project "+selectedProject);
       
      };
  return (
    <div>
        <div className="card" key={manager.userId}>
            <div className="column">
              <div className="name-designation">
              <h2>{manager.name}</h2>
            <p >{manager.designation}</p>
              </div>
            
              <p style={{ marginTop: "1rem" }}>
                <span className="highlight-span">Project :</span>
                <br />
                {/* <span style={{ fontWeight: "bold" }}>Select Project</span>{" "} */}
                <select
                  onChange={handleProjectChange}
                >
                   <option value="">Select Project</option>
                                    {projectList.map((project) => {
                                        return <option key={project.projectId} 
                                        value={project.projectId}
                                        
                                        >{project.projectName}
                                        </option>
                                    })}
                </select>
              </p>
            <p><span className="highlight-span"> Manager : </span>{manager.managerName}</p>
            <p> <span className='highlight-span'>Contact</span> : {manager.contactNo}</p>
            <p><span className="highlight-span"> Email:</span>{manager.email}</p>
            </div>
            <div className="column">
            <p style={{fontSize:"15px"}}><span className="highlight-span">Employee id :  </span> {manager.userId}</p>
            <br></br>
            <p><span className="highlight-span"> Location </span>: {manager.location}</p>
            <p style={{ marginTop: "1rem" }}>
                <span className='highlight-span' style={{ fontWeight: "bold" }}>Project Skills : </span>{" "}
                {
                                   projectList.map((project) => {
                                    if ((project.projectId + "") === selectedProject) {
                                        return project.skills
                                            .map((skill, index) => {
                                                const isLast = index === project.skills.length - 1;
                                                if (isLast)
                                                    return skill
                                                else
                                                    return skill + ", "
                                            }
                                            )
                                    }
                                })}
              </p>
              <p><strong>Team : </strong>{projectList.map((project) => {
                if ((project.projectId+"") === selectedProject) {
                    return project.team.map((team, index) => {
                  const isLast = index === project.team.length - 1;
                  return isLast ? team : team + ",";
                });
              }
              return null;
            })}</p>
            </div>
            

          </div>
    </div>
  )
}

export default ManagerCard;