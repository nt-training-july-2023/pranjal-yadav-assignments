import React, {useState} from 'react';
import { Link, useNavigate } from "react-router-dom";
import ManagerDisplayEmployee from './Employee/ManagerDisplayEmployee';
import DisplayManager from '../AdminDashboard/Manager/DisplayManager';
import DisplayProject from '../AdminDashboard/Project/DisplayProject';
import '../ManagerDashboard/ManagerDashBoard.css'
// import UnauthorisedAccess from '../../component/UnauthorisedAccess';
import UnauthorisedAccess from '../../component/UnauthorizedAccess/UnauthorisedAccess';
import CustomButton from '../../component/CustomButton'
import Header from '../../component/Header/Header';

const ManagerDashBoard = () => {
    const [activeTab, setActiveTab] = useState("EMPLOYEE");
    const navigate = useNavigate();
  const switchToEmployeeTab = () => {
    setActiveTab("EMPLOYEE");
  };
  const switchToManagerTab = () => {
    setActiveTab("MANAGER");
  };
  const switchToProjectTab = () => {
    setActiveTab("PROJECT");
  };
  const role = localStorage.getItem("useRole")
  if(role != "MANAGER"){
    <UnauthorisedAccess/>
    // return;  
  }
  const logout=()=>{
    localStorage.removeItem("userRole")
    localStorage.removeItem("id")
    localStorage.removeItem("isLoggedIn")
    localStorage.removeItem("name")
    localStorage.removeItem("email")
    navigate('/')
  }
  const userRole = localStorage.getItem("userRole")
  if(userRole != "MANAGER"){
    return(
     <UnauthorisedAccess/>
    )
  }

  return (
    <div className="">
      {/* <div className="admin_heading">Admin Dashboard</div> */}
      {/* <button onClick={logout} className="btn-logout">
        Logout
      </button> */}
{/* <CustomButton onClick={logout} style={"btn_logout"} text={"Logout"}/>       */}
      {/* <div className="admin_tabs_manager">
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
      </div> */}
      <div className="admindashboard_header">
      <Header
            activeTab={activeTab}
            switchToEmployeeTab={switchToEmployeeTab}
            switchToManagerTab={switchToManagerTab}
            switchToProjectTab={switchToProjectTab}
          />
          </div>
      
      <div className="">
        {activeTab === "EMPLOYEE" && (
          <div>
            <ManagerDisplayEmployee/>
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