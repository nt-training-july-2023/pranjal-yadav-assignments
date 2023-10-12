import React from "react";
import { useState } from "react";
import Lcn from "../Data/location";
import Desgn from "../Data/designation";
import { useNavigate, Link } from "react-router-dom";
import AdminService from '../../service/AdminService'
import '../../Pages/Registration/AdminRegistrationForm.css'
import PopUp from "../PopUp/Popup";
import R from "../Data/role";
import Skills from "../Data/skills";
import MultiSelectDropDown from "../MultiSelectDropdown/MultiSelectDropDown";
import CustomButton from "../CustomButton";
import InputComponent from "../Input/InputComponent";
import {
  validateName,
  validateEmployeeEmail,
  validateEmpId,
  validateDob,
  validateLocation,
  validateDesignation,
  validateDoj,
  validateContactNumber,
  validateRole,
  validateSkills
} from '../HandleBlur/HandleBlur';


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
  const [skills, setSkills] = useState([]);
  const [role, setRole] = useState("");
  const navigate = useNavigate();
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
  const [skillserror, setSkillsError] = useState("");
  const [roleError, setRoleError] = useState("");
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);
  const [selectedSkills] = useState([]);

  // const selectedSkillsValue = {};
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
    if (!/^[N]\d{4}$/.test(userId) || userId === "") {
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
  const handleRoleBlur = () => {
    if (role === "") {
      setRoleError("Give valid role");
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
  const handleSkillChange = (selectedOptions) => {
    const selectedSkillsValues = selectedOptions.map((option) => option.value);
    setSkills(selectedSkillsValues);
  };

  const saveEmp = (e) => {
    e.preventDefault();

    if (
      !name ||
      !email ||
      !userId ||
      !dob ||
      !doj ||
      !location ||
      !designation ||
      !contactNo ||
      !role ||
      skills.length === 0 

    ) {
      validateName(name, setErrorMessage);
      validateEmployeeEmail(email, setEmailError)
      validateEmpId(userId, setEmpIdError)
      validateDob(dob, setDobError)
      validateDoj(doj, setDojError)
      validateLocation(location, setLocationError)
      validateDesignation(designation, setDesignationError)
      validateContactNumber(contactNo, setContactNumber, setContactNumberError)
      validateRole(role, setRoleError)
      validateSkills(skills, setSkillsError)
      return;
    }

    const part1 = dob.replace(/-/g, "");
    const pwd = userId + "@" + part1;
    const password = bcrypt.hashSync(pwd, 10);
    const date = dob.split("-").reverse().join("-");
    const dojDate = doj.split("-").reverse().join("-")
    setDob(date);
    const employee = {
      name,
      email,
      userId,
      dob:date,
      doj:dojDate,
      location,
      designation,
      contactNo,
      role,
      skills,
      password,
    };
    AdminService.addUser(employee)
      .then((response) => {
        setPopUpMessage("Added Successfully");
        setShowPopUp(true);
        const navigateToDashboard = () => {
          navigate("/adminDashboard");
        };
        setTimeout(navigateToDashboard, 2000);
      })
      .catch((error) => {
        if (error.response.status === 409) {
          setShowPopUp(true);
          setPopUpMessage(error.response.data.message);
        }
        if (error.response.status === 500) {
          setShowPopUp(true);
          setPopUpMessage("This employee already exists");
        }
      });
  };

  return (
    <div className="signup-container">
      <div className="custom-form addEmp_form">
        {showPopUp && (
          <PopUp
            message={popMessage}
            onClose={() => {
              setShowPopUp(false);
            }}
          />
        )}
        <p className="signup_heading">Add Employee</p>
        <form action="">
          <div className="form-section">
            <div className="column">
              <div className="form-group">
                <label>Name</label>
                <InputComponent
                type="text"
                required
                className="input"
                value={name}
                onChange={(e) => {
                  setName(e.target.value);
                  setErrorMessage("");
                }}
                onBlur={() => validateName(name, setErrorMessage)}                />
                <span>{errorMessage}</span>
              </div>

              <div className="form-group">
                <label>Email Id</label>
                <InputComponent
                className="input"
                onChange={(e) => {
                  setEmail(e.target.value);
                  setEmailError("");
                }}
                onBlur={() => validateEmployeeEmail(email, setEmailError)}                type="text"
                />
                <span>{emailError}</span>
              </div>

              <div className="form-group">
                <label>Employee id</label>
                <InputComponent
                type="text"
                className="input"
                value={userId}
                onChange={(e) => {
                  setId(e.target.value);
                  setEmpIdError("");
                }}
                onBlur={() => validateEmpId(userId, setEmpIdError)}                />
                <span>{empIdError}</span>
              </div>

              <div className="form-group">
                <label>DOB</label>
                <InputComponent
                type="date"
                className="input"
                value={dob}
                onChange={(e) => setDob(e.target.value)}
                onBlur={() => validateDob(dob, setDobError)}
                />
                <span>{dobError}</span>
              </div>

              <div className="form-group">
                <label>DOJ</label>
                <InputComponent
                className="input"
                type="date"
                value={doj}
                onChange={(e) => setDoj(e.target.value)}
                onBlur={() => validateDoj(doj, setDojError)}                />
                <span>{dojError}</span>
              </div>
            </div>
            <div className="column">
              <div className="form-group">
                <label>Location</label>
                <select
                  type="text"
                  placeholder="Enter Location"
                  name="location"
                  className="input"
                  onChange={(e) => setLocation(e.target.value)}
                  onBlur={() => validateLocation(location, setLocationError)}                >
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

              <div className="form-group">
                <label>Designation</label>
                <select
                  type="text"
                  placeholder="Enter designation"
                  name="location"
                  className="input"
                  onChange={(e) => setDesignation(e.target.value)}
                  onBlur={() => validateDesignation(designation, setDesignationError)}                >
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
                <label>Skills</label>

                <MultiSelectDropDown
                  className="skill_addProject"
                  options={Skills.map((skill) => ({
                    value: skill,
                    label: skill,
                  }))}
                  selectedOptions={selectedSkills.map((skill) => ({
                    value: skill,
                    label: skill,
                  }))}
                  onChange={handleSkillChange}
                  placeholder="Select Skills"
                  onBlur={() => validateSkills(skills, setSkillsError)}
                />
              </div>

              <div className="form-group">
                <label>Contact Number</label>
                <InputComponent
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
                <select
                  type="text"
                  placeholder="Enter role"
                  name="role"
                  className="input"
                  onChange={(e) => setRole(e.target.value)}
                  onBlur={handleRoleBlur}
                >
                  <option value="">Select Role</option>
                  {R.map((item) => {
                    return (
                      <option key={item} value={item}>
                        {item}
                      </option>
                    );
                  })}
                </select>
                <span>{roleError}</span>
              </div>

              
            </div>
          </div>
          
          <CustomButton text={"Add Employee"} style="submit-button addEmp_submit" onClick={(e) => {saveEmp(e)}}/> 
          <Link to="/adminDashBoard">Cancel</Link>
        </form>
      </div>
    </div>
  );
};

export default AddEmployee;
