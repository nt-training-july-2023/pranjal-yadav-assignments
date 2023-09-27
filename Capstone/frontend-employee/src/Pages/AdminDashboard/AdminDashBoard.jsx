import React, { useState } from "react";
import "./AdminDashBoard.css";
import { Link, useNavigate } from "react-router-dom";
import DisplayEmployee from "./Employee/DisplayEmployee";
import DisplayManager from "./Manager/DisplayManager";
import DisplayProject from "./Project/DisplayProject";

const AdminDashBoard = () => {
  const navigate = useNavigate();
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
  const logout=()=>{
    localStorage.removeItem("email")
    localStorage.removeItem("name")
    localStorage.removeItem("id")
    localStorage.removeItem("userRole")
    navigate("/");
  }

  return (
    <div className="top">
      {/* <div className="admin_heading">Admin Dashboard</div> */}
      <button onClick={logout} className="btn-logout">
        Logout
      </button>
      {/* <Link className="btn-logout" to="/requests">
        Requests
      </Link> */}

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
      {activeTab === "EMPLOYEE" && (
        <div className="add_and_request">
          <Link to="/addEmployee" className="btn-addEmployee">
        Add Employee

      </Link><Link to="/requests" className="btn-requests">
       Requests

      </Link></div>
          
        )}

      {activeTab === "MANAGER" && (
        <Link className="btn-addManager">Add Manager</Link>
      )}
      {activeTab === "PROJECT" && (
        <Link to="/addProject" className="btn-addEmployee">
          Add Project
        </Link>
      )}

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
