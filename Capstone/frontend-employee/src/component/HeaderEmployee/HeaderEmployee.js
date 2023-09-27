import React from 'react'

const HeaderEmployee = ({ activeTab, switchToMyProfileTab, switchToManagerTab }) => {
    return (
        <div className="emp_tabs_dashboard">
          <div
            className={`admin_employee ${activeTab === "MyProfile" ? "active" : ""}`}
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
      );
    };

export default HeaderEmployee