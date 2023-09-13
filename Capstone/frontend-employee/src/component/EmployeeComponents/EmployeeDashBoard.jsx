import React, {useState} from 'react'
import { Link } from "react-router-dom";
import DisplayEmployee from '../DisplayEmployee';
import DisplayManager from "../DisplayManager";
import MyProfile from './MyProfile';

const EmployeeDashBoard = () => {
  const [activeTab, setActiveTab] = useState("MyProfile");
  const switchToMyProfileTab= () => {
    setActiveTab("MyProfile");
  };
  const switchToManagerTab = () => {
    setActiveTab("Organization");
  };
  const switchToProjectTab = () => {
    setActiveTab("PROJECT");
  };
  return (
    <div className="top">
    <div className="admin_heading">Employee DashBoard</div>
    <div className="admin_tabs">
      <div
        className={`admin_employee ${
          activeTab === "MyProfile" ? "active" : ""
        }`}
        onClick={switchToMyProfileTab}
      >
        My Profile
      </div>
      <div
        className={`admin_manager ${activeTab === "Organization" ? "active" : ""}`}
        onClick={switchToManagerTab}
      >
        Manager
      </div>
    </div>
    <Link to="/" className="btn-logout">
      Log out
    </Link>
    
    <div>
      {activeTab === "MyProfile" && (
        <div>
          <MyProfile/>
        </div>
      )}
      {activeTab === "MANAGER" && (
        <div>
          <DisplayManager />
        </div>
      )}
      {/* {activeTab === "PROJECT" && (
        <div>
          <DisplayProject />
        </div>
      )} */}
    </div>
  </div>
  )
}

export default EmployeeDashBoard