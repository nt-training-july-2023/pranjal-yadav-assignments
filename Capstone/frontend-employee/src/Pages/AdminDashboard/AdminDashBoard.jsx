import React, { useState } from "react";
import "./AdminDashBoard.css";
import { Link, useNavigate } from "react-router-dom";
import DisplayEmployee from "./Employee/DisplayEmployee";
import DisplayManager from "./Manager/DisplayManager";
import DisplayProject from "./Project/DisplayProject";
import UnauthorisedAccess from "../../component/UnauthorizedAccess/UnauthorisedAccess";
import CustomButton from "../../component/CustomButton";
import Header from "../../component/Header/Header";

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
  const logout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("name");
    localStorage.removeItem("id");
    localStorage.removeItem("userRole");
    localStorage.removeItem("isLoggedIn");
    navigate("/");
  };
  const role = localStorage.getItem("userRole");
  if (role != "ADMIN") {
    return <UnauthorisedAccess />;

    // return
  }

  return (
    <div className="">
      {/* <CustomButton text={"Logout"} onClick={logout} style={"btn-logout"} /> */}

      {/* <div className="admin_tabs">
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
      {activeTab === "EMPLOYEE" && (
        <div className="add_and_request">
          
          <CustomButton text={"Add Employee"} onClick={() => {navigate("/addEmployee")}} style={"addEmployee_admin "}/>
          <CustomButton text={"Requests"} onClick={() => {navigate("/requests")}} style={"requests_admin"}/>
        </div>
      )}
      {activeTab === "MANAGER" && (
        
        
        <CustomButton text={"Requests"} onClick={() => {navigate("/requests")}} style={"requests request_manager"}/>
      ) }

      {activeTab === "PROJECT" && (
        <>
                <CustomButton text={"Add Project"} onClick={() => {navigate("/addProject")}} style={"addProject_admin"}/>

        <CustomButton text={"Requests"} onClick={() => {navigate("/requests")}} style={"requests request_project"}/>
        {/* <Link to="/addProject" className="btn-addEmployee">
          Add Project
        </Link> */}
        </>
      )}

      <div className="">
        {activeTab === "EMPLOYEE" && (
          
            <DisplayEmployee />
         
        )}
        {activeTab === "MANAGER" && (
          
            <DisplayManager />
          
        )}
        {activeTab === "PROJECT" && (
          
            <DisplayProject />
        
        )}
      </div>
    </div>
  );
};

export default AdminDashBoard;
