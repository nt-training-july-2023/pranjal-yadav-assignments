import React from "react";

const SingleProjectCard = ({
  project,
  managerName,
  reverseDateFormat,
  handleReadMoreClick,
}) => {
  return (
    <>
      <div className="card" key={project.projectId}>
        <div className="column">
          <h2>{project.projectName}</h2>
          <p>
            <span className="highlight-span">Head :</span>
            {managerName ? managerName : "Loading..."}
          </p>
          <p>
            <span className="highlight-span">Description: </span>
            {project.description.length > 40 ? (
              <p>
                {project.description.slice(0, 30)}
                {""}
                <span
                  style={{ color: "blue", textDecorationLine: "underline" }}
                  onClick={() => handleReadMoreClick(project.description)}
                >
                  <br />
                  Read More
                </span>
              </p>
            ) : (
              <p>{project.description}</p>
            )}
          </p>
        </div>
        <div className="column">
          
          <p>
            <span className="highlight-span">Start Date</span> :{" "}
            {reverseDateFormat(project.startDate)}
          </p>
          <p>
            <span className="highlight-span">Project ID:</span>{" "}
            {project.projectId}
          </p>
          <p>
            {" "}
            <span className="highlight-span">Skills: </span>
            {project.skills.join(" , ")}
          </p>
          <p>
            {" "}
            <span className="highlight-span">Team: </span>
            {project.team.join(" , ")}
          </p>
        </div>
      </div>
    </>
  );
};

export default SingleProjectCard;
