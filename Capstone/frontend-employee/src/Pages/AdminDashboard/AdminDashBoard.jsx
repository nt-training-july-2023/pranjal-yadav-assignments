import React, { useState } from "react";
import "./AdminDashBoard.css";
import { useNavigate } from "react-router-dom";
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
  
  const role = localStorage.getItem("userRole");
  if (role !== "ADMIN") {
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
      {activeTab === "EMPLOYEE" && (
        <div className="add_and_request">
          <CustomButton
            text="Add Employee"
            onClick={() => {
              navigate("/addEmployee");
            }}
            style="addEmployee_admin "
          />
          <CustomButton
            text="Requests"
            onClick={() => {
              navigate("/requests");
            }}
            style="requests_admin"
          />
        </div>
      )}
      {activeTab === "MANAGER" && (
        <CustomButton
          text="Requests"
          onClick={() => {
            navigate("/requests");
          }}
          style="requests request_manager"
        />
      )}

      {activeTab === "PROJECT" && (
        <>
          <CustomButton
            text="Add Project"
            onClick={() => {
              navigate("/addProject");
            }}
            style="addProject_admin"
          />

          <CustomButton
            text="Requests"
            onClick={() => {
              navigate("/requests");
            }}
            style="requests request_project"
          />
        </>
      )}

      <div className="">
        {activeTab === "EMPLOYEE" && <DisplayEmployee />}
        {activeTab === "MANAGER" && <DisplayManager />}
        {activeTab === "PROJECT" && <DisplayProject />}
      </div>
    </div>
  );
};

export default AdminDashBoard;
