import React from "react";
import "./ProjectPopUp.css";
import CustomButton from "../CustomButton";

const ProjectPopUp = ({ description, onClose }) => {
  return (
    <div className="project_popup">
      <div className="project_popup_content">
        Description
        <p className="popup_description">{description}</p>
        <CustomButton
          text={"Close"}
          style="close_description"
          onClick={onClose}
        />
      </div>
    </div>
  );
};

export default ProjectPopUp;
