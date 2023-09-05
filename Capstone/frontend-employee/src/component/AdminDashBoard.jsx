import React, { useState } from "react";
import "../style/AdminDashBoard.css";
import { Link } from "react-router-dom";
import DisplayEmployee from "./DisplayEmployee";
import DisplayManager from "./DisplayManager";
import DisplayProject from "./DisplayProject";

const AdminDashBoard = () => {
  const [activeTab, setActiveTab] = useState("USER");
  const switchToEmployeeTab = () => {
    setActiveTab("EMPLOYEE");
  };
  const switchToManagerTab = () => {
    setActiveTab("MANAGER");
  };
  const switchToProjectTab = () => {
    setActiveTab("project");
  };

  return (
    <div className="top">
      <div className="admin_heading">Admin Dashboard</div>
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
          className={`admin_project ${activeTab === "project" ? "active" : ""}`}
          onClick={switchToProjectTab}
        >
          Project
        </div>
      </div>
      <Link to="/addEmployee" className="btn-addEmployee">
        Add Employee
      </Link>
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
        {activeTab === "project" && (
          <div>
            <DisplayProject />
          </div>
        )}
      </div>
    </div>
    // <div>
    //   <div className="container">
    //     <h1 className="admin-heading">Admin DashBoard</h1>
    //     <div className="admin-tabs">
    //       <div
    //         className={`admin_employee ${
    //           activeTab === "USER" ? "active" : ""
    //         }`}
    //         onClick={switchToEmployeeTab}
    //       >
    //         Employee
    //       </div>
    //       <div
    //         className={`admin_manager ${
    //           activeTab === "MANAGER" ? "active" : ""
    //         }`}
    //         onClick={switchToManagerTab}
    //       >
    //         Manager
    //       </div>
    //       <div
    //         className={`admin_project ${
    //           activeTab === "project" ? "active" : ""
    //         }`}
    //         onClick={switchToProjectTab}
    //       >
    //         Project
    //       </div>
    //     </div>
    //   </div>
    //   <Link to="/addEmployee" className="btn-addEmployee">
    //     Add Employee
    //   </Link>
    //   <div className='card_container'>
    //   {activeTab === 'USER' && (
    //       <div>
    //        <DisplayEmployee/>
    //       </div>
    //     )}
    //      {activeTab === 'MANAGER' && (
    //       <div >
    //        <DisplayManager/>
    //       </div>
    //     )}
    //     {activeTab === 'project' && (
    //       <div >
    //        <DisplayProject/>
    //       </div>
    //     )}
    //   </div>
    // </div>
  );
};

export default AdminDashBoard;
