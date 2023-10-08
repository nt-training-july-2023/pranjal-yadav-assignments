import React, { useState, useEffect } from "react";
import "./Header.css";
import { useNavigate } from "react-router-dom";

const Header = ({
  activeTab,
  switchToEmployeeTab,
  switchToManagerTab,
  switchToProjectTab,
}) => {
  const [isLoggedIn, setIsLoggedIn] = useState(!!localStorage.getItem("email"));
  const [userName, setUserName] = useState("");
  const navigate = useNavigate();
  useEffect(() => {
    // Retrieve the user's name from local storage
    const name = localStorage.getItem("name");
    setUserName(name || ""); // Set the user's name in state
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("email");
    localStorage.removeItem("role");
    localStorage.removeItem("name");
    localStorage.removeItem("id");
    localStorage.removeItem("isLoggedIn");
    // setIsLoggedIn(false);
    navigate("/");
  };
  console.log(isLoggedIn);

  return (
    <div>
      <div className="header-container">
        <div className="admin_heading">Welcome {userName} !!</div>
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
            className={`admin_manager ${
              activeTab === "MANAGER" ? "active" : ""
            }`}
            onClick={switchToManagerTab}
          >
            Manager
          </div>
          <div
            className={`admin_project  ${
              activeTab === "PROJECT" ? "active" : ""
            }`}
            onClick={switchToProjectTab}
          >
            Project
          </div>
        </div>
        <button onClick={handleLogout} className="headerlogout">
          Logout
        </button>
        {/* <CustomButton text={"Requests"} onClick={() => {navigate("/requests")}} style={"requests"}/> */}
      </div>
    </div>
  );
};

export default Header;
