import React, { useState } from "react";
import "../style/AdminDashBoard.css";
import { Link } from "react-router-dom";
import DisplayEmployee from "./DisplayEmployee";
import DisplayManager from "./DisplayManager";
import DisplayProject from "./DisplayProject";

const AdminDashBoard = () => {
  const [activeTab, setActiveTab] = useState("EMPLOYEE");
  const switchToEmployeeTab = () => {
    setActiveTab("EMPLOYEE");
  };
  const switchToManagerTab = () => {
    setActiveTab("MANAGER");
  };
  const switchToProjectTab = () => {
    setActiveTab("PROJECT");
  };

  return (
    <div className="top">
      {/* <div className="admin_heading">Admin Dashboard</div> */}
      <Link to="/" className="btn-logout">
        Log out
      </Link>
      
      <div className="admin_tabs">
        <div
          className={`admin_employee ${
            activeTab === "EMPLOYEE" ? "active" : ""
          }`}
          onClick={switchToEmployeeTab}
        >
          Employee
        </div>
        <div
          className={`admin_manager ${activeTab === "MANAGER" ? "active" : ""}`}
          onClick={switchToManagerTab}
        >
          Manager
        </div>
        <div
          className={`admin_project ${activeTab === "PROJECT" ? "active" : ""}`}
          onClick={switchToProjectTab}
        >
          Project
        </div>
      </div>
      {activeTab==="EMPLOYEE" && (<Link to="/addEmployee" className="btn-addEmployee">
        Add Employee
      </Link>)}
      {activeTab==="MANAGER" && (<Link className="btn-addManager">
        Add Manager
      </Link>)}
      {activeTab==="PROJECT" && (<Link to="/addProject" className="btn-addEmployee">
        Add Project
      </Link>)}
      
      <div className="card_container">
        {activeTab === "EMPLOYEE" && (
          <div>
            <DisplayEmployee />
          </div>
        )}
        {activeTab === "MANAGER" && (
          <div>
            <DisplayManager />
          </div>
        )}
        {activeTab === "PROJECT" && (
          <div>
            <DisplayProject />
          </div>
        )}
      </div>
    </div>
  );
};

export default AdminDashBoard;
