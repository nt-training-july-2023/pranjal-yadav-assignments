import React from "react";
import { useState } from "react";
import Lcn from "../list/location";
import Desgn from "../list/designation";
import { useNavigate } from "react-router-dom";
import AddEmployeeService from "../service/AddEmployeeService";
import '../style/AdminRegistrationForm.css'
import PopUp from "./Popup";

const AddEmployee = () => {
  var bcrypt = require("bcryptjs");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [userId, setId] = useState("");
  const [dob, setDob] = useState("");
  const [doj, setDoj] = useState("");
  const [location, setLocation] = useState("");
  const [designation, setDesignation] = useState("");
  const [contactNo, setContactNumber] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setconfirmPassword] = useState("");
  const [skills, setSkills] = useState("");
  const [role, setRole] = useState("");
  const navigate = useNavigate();
  //ERRORS
  const [errorMessage, setErrorMessage] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [dobError, setDobError] = useState("");
  const [dojError, setDojError] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");
  const [locationError, setLocationError] = useState("");
  const [designationError, setDesignationError] = useState("");
  //const [emailError, setEmailError] = useState("");
  const [skillserror, setSkillsError] = useState("");
  const [roleError, setRoleError] = useState("");
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);
  //HANDLE BLURS

  const handleNameBlur = () => {
    if (/^-?\\d/.test(name) || name === "") {
      setErrorMessage("Give valid name");
    }
  };
  const handleEmailBlur = () => {
    if (!email.endsWith("@nucleusteq.com" || email === "")) {
      setEmailError("Give valid email");
    }
  };
  const handleEmpIDBlur = () => {
    if (!/^[N]\d{3}$/.test(userId) || userId === "") {
      setEmpIdError("Employee ID should be in pattern NXXX");
    } else {
      setEmpIdError("");
    }
  };
  const handlePhoneNo = () => {
    if (!/^\d{10}$/.test(contactNo)) {
      setContactNumberError("Contact no should have 10 digits only");
    } else {
      setContactNumberError("");
    }
  };
  const handleDobBlur = () => {
    const today = new Date();
    const dobDate = new Date(dob);
    const minDate = new Date(
      today.getFullYear() - 18,
      today.getMonth(),
      today.getDate()
    );
    if (isNaN(dobDate) || dobDate > minDate) {
      setDobError("You must be at least 18 years old.");
    } else {
      setDobError("");
    }
  };

  const handleDojblur = () => {
    const today = new Date();
    const dojDate = new Date(doj);
    if (isNaN(dojDate) || dojDate > today) {
      setDojError("Date of Joining cannot be in the future.");
    } else {
      setDojError("");
    }
  };
  const handleLocationBlur = () => {
    if (location === "") {
      setLocationError("Give location");
    }
  };

  const handleDesignationBlur = () => {
    if (designation === "") {
      setDesignationError("Give designation");
    }
  };
  // const handlePassword = () => {
  //   if (password !== confirmPassword) {
  //     setPasswordError("Password and confirm password do not match");
  //     setConfirmPasswordError("Password and confirm password do not match");
  //     //alert("Passwords dont match");
  //   } else {
  //     setPasswordError("");
  //     setConfirmPasswordError("");
  //   }
  // };

  const handleskills = () => {
    if (skills === "") {
      setSkillsError("Give skills");
    }
  };
  const saveEmp = (e) => {
    e.preventDefault();
    if (
      name === "" ||
      email === "" ||
      contactNo === "" ||
      Desgn === "" ||
      Lcn === "" ||
      dob === "" ||
      doj === "" ||
      skills===""||
      role==="" ||
      userId === ""
    ) {
      setConfirmPasswordError("Mandatory field");
      setContactNumberError("Mandatory field");
      setEmailError("Mandatory field");
      setErrorMessage("Mandatory field");
      setEmpIdError("Mandatory field");
      setPasswordError("Mandatory field");
      setDesignationError("Mandatory field");
      setDobError("Mandatory field");
      setDojError("Mandatory field");
      setLocationError("Mandatory field");
      setPasswordError("Madatory field");
      setConfirmPasswordError("Mandatory field");
      setRoleError("Mandatory field");
      setSkillsError("Mandatory field");
      return;
    }

    const pwd = userId + dob;
    const password = bcrypt.hashSync(pwd, 10);
    const employee = {
      name,
      email,
      userId,
      dob,
      doj,
      location,
      designation,
      contactNo,
      role,
      skills,
      password,
    };
    AddEmployeeService.createEmp(employee)
        .then((response) => {
          // console.log(response.data);
          // if (response.data.responseStatus === 200) {
          //   setPopUpMessage("Admin Registered");
          //   setShowPopUp(true);
          // }
          // navigate("/");
          setPopUpMessage("Added Successfully");
          setShowPopUp(true);
          // navigate("/admindashboard");
          const navigateToDashboard = () => {
            navigate("/AdminDashboard");
          };
          setTimeout(navigateToDashboard, 2000);
        })
        .catch((error) => {
          console.log(error);
          //setEmailError(error.response.data.message);
          // if (error.response.status === 302) {
          //   setShowPopUp(true);
          //   setPopUpMessage("Email already exists");
          // }
          if (error.response.status === 409) {
            setShowPopUp(true);
            setPopUpMessage(error.response.data.errorMessage);
          }
        });
  };

  return (
    <div className="signup-container">
      <div className="custom-form">
      {showPopUp && (
          <PopUp
            message={popMessage}
            onClose={() => {
              setShowPopUp(false);
            }}
          />
        )}
        <h2 className="title">Add Employee</h2>
        <form action="">
          <div className="form-section">
            <div className="column">
              <div className="form-group">
                <label>Name</label>
                <input
                  type="text"
                  required
                  className="input"
                  value={name}
                  onChange={(e) => {
                    setName(e.target.value);
                    setErrorMessage("");
                  }}
                  onBlur={handleNameBlur}
                />
                <span>{errorMessage}</span>
              </div>

              <div className="form-group">
                <label>Email Id</label>
                <input
                  className="input"
                  onChange={(e) => {
                    setEmail(e.target.value);
                    setEmailError("");
                  }}
                  onBlur={handleEmailBlur}
                  type="text"
                />
                <span>{emailError}</span>
              </div>

              <div className="form-group">
                <label>Employee id</label>
                <input
                  type="text"
                  className="input"
                  value={userId}
                  onChange={(e) => {
                    setId(e.target.value);
                    setEmpIdError("");
                  }}
                  onBlur={handleEmpIDBlur}
                />
                <span>{empIdError}</span>
              </div>

              <div className="form-group">
                <label>DOB</label>
                <input
                  type="date"
                  className="input"
                  value={dob}
                  onChange={(e) => setDob(e.target.value)}
                  onBlur={handleDobBlur}
                />
                <span>{dobError}</span>
              </div>

              <div className="form-group">
                <label>DOJ</label>
                <input
                  className="input"
                  type="date"
                  value={doj}
                  onChange={(e) => setDoj(e.target.value)}
                  onBlur={handleDojblur}
                />
                <span>{dojError}</span>
              </div>
            </div>
            {/* ///////////////////////////////////////////// */}
            {/* <div className="column">
              <div className="form-group">
                <label>Location</label>
                <input
                  className="input"
                  type="text"
                  value={location}
                  onChange={(e) => setLocation(e.target.value)}
                />
                <span>{locationError}</span>
              </div> */}
            <div className="column">
              <div className="form-group">
                <label>Location</label>
                <select
                  // value={location}
                  type="text"
                  placeholder="Enter Location"
                  name="location"
                  className="input"
                  onChange={(e) => setLocation(e.target.value)}
                  onBlur={handleLocationBlur}
                >
                  <option value="">Select Location</option>
                  {Lcn.map((item) => {
                    return (
                      <option key={item} value={item}>
                        {item}
                      </option>
                    );
                  })}
                </select>
                <span>{locationError}</span>
              </div>

              {/* <div className="form-group">
                <label>Designation</label>
                <input
                  className="input"
                  type="text"
                  value={designation}
                  onChange={(e) => setDesignation(e.target.value)}
                />
                <span>{designationError}</span>
              </div> */}

              <div className="form-group">
                <label>Designation</label>
                <select
                  type="text"
                  placeholder="Enter designation"
                  name="location"
                  className="input"
                  onChange={(e) => setDesignation(e.target.value)}
                  onBlur={handleDesignationBlur}
                >
                  <option value="">Select Designation</option>
                  {Desgn.map((item) => {
                    return (
                      <option key={item} value={item}>
                        {item}
                      </option>
                    );
                  })}
                </select>
                <span>{designationError}</span>
              </div>

              <div className="form-group">
                <label>Contact Number</label>
                <input
                  className="input"
                  type="text"
                  value={contactNo}
                  onChange={(e) => {
                    setContactNumber(e.target.value);
                  }}
                  onBlur={handlePhoneNo}
                />
                <span>{contactNumberError}</span>
              </div>

              <div className="form-group">
                <label>Role</label>
                <input
                  className="input"
                  type="text"
                  value={role}
                  onChange={(e) => setRole(e.target.value)}
                />
                <span>{roleError}</span>
              </div>

              <div className="form-group">
                <label>Skills</label>
                <input
                  className="input"
                  type="text"
                  value={skills}
                  onChange={(e) => {
                    setSkills(e.target.value);
                  }}
                  onBlur={handleskills}
                />
                <span>{skillserror}</span>
              </div>
            </div>
          </div>
          <button
            className="submit-button"
            onClick={(e) => saveEmp(e)}
            type="submit"
          >
            Sign Up
          </button>
        </form>
      </div>
    </div>
  );
};

export default AddEmployee;
