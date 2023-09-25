import React from 'react';
import './ProjectPopUp.css'

const ProjectPopUp = ({ description, onClose }) => {
  return (
    <div className="project-popup">
      <div className="project-popup-content">
        Description
        <p className='popup-description'>{description}</p>
         
      </div>
      <a className="close-button" onClick={onClose}>
          Close
          </a>
    </div>
  );
};

export default ProjectPopUp;