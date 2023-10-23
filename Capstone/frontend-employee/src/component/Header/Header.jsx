import React, { useState, useEffect } from "react";
import "./Header.css";
import { useNavigate } from "react-router-dom";
import DisableBackButton from "../DisableBack/DisableBackButton";

const Header = ({
  activeTab,
  switchToEmployeeTab,
  switchToManagerTab,
  switchToProjectTab,
}) => {
  const [userName, setUserName] = useState("");
  const navigate = useNavigate();
  useEffect(() => {
    const name = localStorage.getItem("name");
    setUserName(name || ""); 
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("role");
    localStorage.removeItem("name");
    localStorage.removeItem("id");
    localStorage.removeItem("isLoggedIn");
    navigate("/");
  };

  return (
    
    <div>
      <DisableBackButton/>
      <div className="header-container">
        <div className="admin_heading">Welcome {userName} !!</div>
        <div className="admin_tabs">
          <div
            className={`admin_employee ${
              activeTab === "EMPLOYEE" ? "active" : ""
            }`}
            onClick={switchToEmployeeTab}
          >
     &#x1F464;   Employee
          </div>
          <div
            className={`admin_manager ${
              activeTab === "MANAGER" ? "active" : ""
            }`}
            onClick={switchToManagerTab}
          >
          &#x1F464; Manager
          </div>
          <div
            className={`admin_project  ${
              activeTab === "PROJECT" ? "active" : ""
            }`}
            onClick={switchToProjectTab}
          >
            📁 Project
          </div>
        </div>
        <button onClick={handleLogout} className="headerlogout">
        Logout
        </button>
      </div>
    </div>
  );
};

export default Header;
