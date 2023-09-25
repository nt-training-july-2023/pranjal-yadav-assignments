import React, {useState} from 'react'
import { Link } from "react-router-dom";
import DisplayEmployee from '../AdminDashboard/Employee/DisplayEmployee';
import DisplayManager from "../AdminDashboard/Manager/DisplayManager";
import '../EmployeeDashboard/MyProfile.css';
import MyProfile from './Profile/MyProfile';
import EmpDisplayEmployee from './Organization/EmpDisplayEmployee';

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
    <div className="top-employee">
    <div style={{textAlign : 'center'}} className="employee_heading"></div>
    <div className="emp_tabs">
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
        Organization
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
      {activeTab === "Organization" && (
        <div>
          <EmpDisplayEmployee />
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