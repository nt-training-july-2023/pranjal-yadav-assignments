import { useState } from "react";
import React from "react";
import CustomButton from "../CustomButton";
import Popup from "../PopUp/Popup";
import { useNavigate } from "react-router-dom";
import AdminService from "../../service/AdminService";

const EmployeeCard = ({ employee }) => {
  const role = localStorage.getItem("userRole");
  const navigate = useNavigate();
  const [isPopupOpen, setIsPopupOpen] = useState(false);

  const accept = async (employee) => {
    try {
      AdminService.unassign(employee.id).then((response) => {
        window.location.reload();
        setIsPopupOpen(false);
      });
    } catch (error) {
    }
  };

  return (
    <>
      <div className="card" key={employee.id}>
        <div className="column column_2">
          <div className="name_designation">
            <h2 className="emp_name">{employee.name}</h2>
            <p>{employee.designation}</p>
          </div>

          <p>
            <span className="highlight-span">Project Name : </span>{" "}
            {employee.projectName}
          </p>
          <p>
            <span className="highlight-span">Manager :</span>
            {employee.managerName}
          </p>
          <p>
            <span className="highlight-span">Contact : </span>
            {employee.contactNo}
          </p>
          <p>
            <span className="highlight-span">Email : </span>

            {employee.email}
          </p>
          
        </div>
        <div className="column">
          <p className="emp-id" style={{ fontSize: "15px" }}>
            <span className="highlight-span ">Employee id : </span>
            {employee.userId}
          </p>
          <div className="lower_half">
          <p className="manager_emp">
            <span className="highlight-span">DOB : </span>
            {employee.dob}
          </p>
          <p>
            <span className="highlight-span">DOJ: </span>
            {employee.doj}
          </p>
          <p>
            <span className="highlight-span">Location : </span>
            {employee.location}
          </p>
          {role === "MANAGER" && (
            <p>
              <span className="highlight-span">Skills: </span>
              {employee.skills.join(", ")}
            </p>
          )}
          
          {role === "ADMIN" ? (
            employee.projectId ? (
              <>
                <CustomButton
                  style="assign-button"
                  onClick={() => setIsPopupOpen(true)}
                  text={"Unassign"}
                />

                {isPopupOpen && (
                  <Popup
                    message="Do you want to unaasign project to ?"
                    onClose={() => setIsPopupOpen(false)}
                    showAcceptButton={true}
                    onAccept={() => {

                      accept(employee);
                    }}
                  />
                )}
              </>
            ) : (
              <button
                className="assign-button"
                onClick={() =>
                  navigate("/assignProject", {
                    state: { empId: employee.id, empName: employee.name },
                  })
                }
              >
                Assign project
              </button>
            )
          ) : null}

          {role === "MANAGER" && employee.projectName === "N/A" && (
            <p>
              {employee.isRequested ? (
                <CustomButton text="Requested" style="not_active_button" />
              ) : (
                <CustomButton
                  text="Request Resource"
                  onClick={() => {
                    navigate("/requestResource", {
                      state: { empId: employee.id, empName: employee.name },
                    });
                  }}
                  style="MD-btn"
                />
              )}
            </p>
          )}
          </div>
          
        </div>
      </div>
    </>
  );
};

export default EmployeeCard;
