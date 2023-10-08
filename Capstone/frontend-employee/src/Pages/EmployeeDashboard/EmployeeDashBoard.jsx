import React, {useState} from 'react'
import { Link, useNavigate } from "react-router-dom";
import '../EmployeeDashboard/MyProfile.css';
import MyProfile from './Profile/MyProfile';
import EmpDisplayEmployee from './Organization/EmpDisplayEmployee';
import HeaderEmployee from '../../component/HeaderEmployee/HeaderEmployee';
// import UnauthorisedAccess from '../../component/UnauthorisedAccess';
import UnauthorisedAccess from '../../component/UnauthorizedAccess/UnauthorisedAccess';

const EmployeeDashBoard = () => {
  const [activeTab, setActiveTab] = useState("MyProfile");
  const navigate = useNavigate()
  const switchToMyProfileTab= () => {
    setActiveTab("MyProfile");
  };
  const switchToManagerTab = () => {
    setActiveTab("Organization");
  };
 
  const logout=()=>{
    localStorage.removeItem("userRole")
    localStorage.removeItem("id")
    localStorage.removeItem("isLoggedIn")
    localStorage.removeItem("name")
    localStorage.removeItem("email")
    navigate('/')
  }
  const userRole = localStorage.getItem("userRole")
  if(userRole != "EMPLOYEE"){
    return(
     <UnauthorisedAccess/>
    )
  }
  return (
    <div className="top-employee">
      <HeaderEmployee 
      activeTab={activeTab}
      switchToMyProfileTab={switchToMyProfileTab}
      switchToManagerTab={switchToManagerTab}
      />
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
      
    </div>
  </div>
  )
}

export default EmployeeDashBoard