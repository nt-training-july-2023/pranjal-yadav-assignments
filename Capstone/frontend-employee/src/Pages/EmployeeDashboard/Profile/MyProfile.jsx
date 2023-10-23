import React, { useEffect, useState } from "react";
import "../../EmployeeDashboard/MyProfile.css";
import { useNavigate } from "react-router-dom";
import AdminService from "../../../service/AdminService";
import CustomButton from "../../../component/CustomButton";

const MyProfile = () => {
  useEffect(() => {
    getEmployee();
  }, []);
  const navigate = useNavigate();
  const [employee, setEmployee] = useState([]);
  const [empName, setEmpName] = useState("");
  const [userId, setUserId] = useState("");

  const getEmployee = async () => {
    const empEmail = localStorage.getItem("email");
    const id = localStorage.getItem("id");
    AdminService.getUserById(id).then((response) => {
      setEmployee(response.data);
      setUserId(response.data.userId);
      setEmpName(employee.name);
    });
  };
  return (
    <div className="container_my_profile">
      <h3 style={{ marginLeft: "26rem" , color: "white"}}>Employee ID : {userId}</h3>
      <div className="main-profile">
        {employee ? (
          <div>
            <div className="MyProfile_form">
              <div className="my_details_container">
                <div className="column_my_details">
                  <strong>Name</strong>
                  <p className="field_input">{employee.name}</p>
                  <strong>Email</strong>
                  <p className="field_input">{employee.email}</p>

                  <strong>DOB</strong>
                  <p className="field_input">{employee.dob}</p>

                  <strong>Skills</strong>
                  <p className="field_input_skills">
                    {employee.skills ? employee.skills.join(", ") : "N/A"}
                  </p>
                  <CustomButton
                    text="Update Skills"
                    style="btn"
                    onClick={() => {
                      navigate("/updateSkills", {
                        state: {
                          empId: employee.id,
                          empName: employee.name,
                          empSkills: employee.skills,
                        },
                      });
                    }}
                  />
                </div>

                <div className="column-my-details">
                  <strong>Contact No</strong>
                  <p className="field_input">{employee.contactNo}</p>
                  <strong>Project Name</strong>
                  <p className="field_input">{employee.projectName}</p>

                  <strong>Manager</strong>
                  <p className="field_input">{employee.managerName}</p>

                  <strong>DOJ</strong>
                  <p className="field_input">{employee.doj}</p>

                  <strong>Location</strong>
                  <p className="field_input">{employee.location}</p>
                </div>
              </div>
            </div>
          </div>
        ) : (
          <p>Loading employee details...</p>
        )}
      </div>
    </div>
  );
};

export default MyProfile;
