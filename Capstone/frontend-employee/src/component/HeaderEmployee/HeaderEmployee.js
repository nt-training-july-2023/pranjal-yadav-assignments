import React from "react";
import CustomButton from "../CustomButton";
import "../HeaderEmployee/HeaderEmployee.css";
import { useNavigate } from "react-router-dom";
import DisableBackButton from "../DisableBack/DisableBackButton";

const HeaderEmployee = ({
  activeTab,
  switchToMyProfileTab,
  switchToManagerTab,
}) => {
  const navigate = useNavigate();
  const logout = () => {
    localStorage.removeItem("userRole");
    localStorage.removeItem("id");
    localStorage.removeItem("isLoggedIn");
    localStorage.removeItem("name");
    localStorage.removeItem("email");
    navigate("/");
  };
  return (
    <div>
      <DisableBackButton/>
      <div className="employee_heading">
        Welcome {localStorage.getItem("name")} !!
      </div>

      <div className="emp_tabs_dashboard">
        <div
          className={`admin_employee ${
            activeTab === "MyProfile" ? "active" : ""
          }`}
          onClick={switchToMyProfileTab}
        >
         &#x1F464; My Profile
        </div>
        <div
          className={`admin_manager ${
            activeTab === "Organization" ? "active" : ""
          }`}
          onClick={switchToManagerTab}
        >
          &#x1F3E2; Organization
        </div>
      </div>
      <div className="logout_div">
        {activeTab === "MyProfile" && (
          <CustomButton
            text={"Log-out"}
            style="emp_logout"
            onClick={logout}
          />
        )}
        {activeTab === "Organization" && (
          <CustomButton
            text={"Log-out"}
            style="emp_logout_org"
            onClick={logout}
          />
        )}
      </div>
    </div>
  );
};

export default HeaderEmployee;
