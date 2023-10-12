import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import ManagerDisplayEmployee from "./Employee/ManagerDisplayEmployee";
import DisplayManager from "../AdminDashboard/Manager/DisplayManager";
import DisplayProject from "../AdminDashboard/Project/DisplayProject";
import "../ManagerDashboard/ManagerDashBoard.css";
import UnauthorisedAccess from "../../component/UnauthorizedAccess/UnauthorisedAccess";
import Header from "../../component/Header/Header";

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
  const role = localStorage.getItem("useRole");
  if (role != "MANAGER") {
    <UnauthorisedAccess />;
  }
  const logout = () => {
    localStorage.removeItem("userRole");
    localStorage.removeItem("id");
    localStorage.removeItem("isLoggedIn");
    localStorage.removeItem("name");
    localStorage.removeItem("email");
    navigate("/");
  };
  const userRole = localStorage.getItem("userRole");
  if (userRole != "MANAGER") {
    return <UnauthorisedAccess />;
  }

  return (
    <div className="">
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
};

export default ManagerDashBoard;
