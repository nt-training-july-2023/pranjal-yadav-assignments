import React, {useState} from 'react';
import { Link } from "react-router-dom";
import ManagerDisplayEmployee from '../ManagerComponent/ManagerDisplayEmployee';
import DisplayManager from '../DisplayManager';
import DisplayProject from '../DisplayProject';


const ManagerDashBoard = () => {
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
     
      
      <div className="card_container">
        {activeTab === "EMPLOYEE" && (
          <div>
            <ManagerDisplayEmployee />
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
}

export default ManagerDashBoard