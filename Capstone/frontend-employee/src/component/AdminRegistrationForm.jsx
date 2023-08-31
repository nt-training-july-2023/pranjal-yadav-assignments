import React, { useState } from "react";
import AdminService from "../service/AdminService";
import "../style/AdminRegistrationForm.css";
import { useNavigate } from "react-router-dom";
import Location from "../list/location";
import Designation from "../list/designation";

var bcrypt = require("bcryptjs");
var salt = bcrypt.genSaltSync(10);

const AdminRegistrationForm = () => {
  const [adminName, setName] = useState("");
  const [adminEmail, setEmail] = useState("");
  const [adminId, setId] = useState("");
  const [adminDob, setDob] = useState("");
  const [adminDoj, setDoj] = useState("");
  const [adminlocation, setLocation] = useState("");
  const [adminDesignation, setDesignation] = useState("");
  const [adminConatctNo, setContactNumber] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setconfirmPassword] = useState("");

  //ERRORS
  const [errorMessage, setErrorMessage] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");
  const [locationError, setLocationError] = useState("");
  const [designationError, setDesignationError] = useState("");
  //const [emailError, setEmailError] = useState("");

  const navigate = useNavigate();

  //HANDLING ERRORS

  const handleNameBlur = () => {
    if (/^-?\\d/.test(adminName) || adminName === "") {
      setErrorMessage("Give valid name");
    }
  };
  const handleEmailBlur = () => {
    if (!adminEmail.endsWith("@nucleusteq.com") || adminEmail == "") {
      setEmailError("Give valid email id");
      setEmail("");
    }
  };

  const handleEmpIDBlur = () => {
    if (!/^[Nn]\d{3}$/.test(adminId)) {
      setEmpIdError("Employee ID should be in pattern NXXX");
    } else {
      setEmpIdError("");
    }
  };

  const handlePhoneNo = () => {
    if (!/^\d{10}$/.test(adminConatctNo)) {
      setContactNumberError("Contact no should have 10 digits only");
    } else {
      setContactNumberError("");
    }
  };

  const handleLocation=(e)=>{
    
  }

  const handlePassword = () => {
    if (password !== confirmPassword) {
      setPasswordError("Password and confirm password do not match");
      setconfirmPassword("Password and confirm password do not match");
      alert("Passwords dont match");
    } else {
      setPasswordError("");
      setConfirmPasswordError("");
    }
  };

  const saveAdmin = (e) => {
    e.preventDefault();
    var hash = bcrypt.hashSync(password, salt);
    if (
      adminName === "" ||
      adminDob === "" ||
      adminDoj === "" ||
      adminConatctNo === "" ||
      Designation === "" ||
      adminEmail === "" ||
      adminId === ""||
      Location === ""
    ) {
      setConfirmPasswordError("Mandatory field");
      setContactNumberError("Mandatory field");
      setEmailError("Mandatory field");
      setErrorMessage("Mandatory field");
      setEmpIdError("Mandatory field");
      setPasswordError("Mandatory field");
      setDesignationError("Mandatory field");
      setLocationError("Mandatory field");
    }
    const admin = {
      adminName,
      adminEmail,
      adminId,
      adminDob,
      adminDoj,
      adminlocation,
      adminDesignation,
      adminConatctNo,
      password,
    };
    // const admin2 = {
    //   adminName,
    //   adminEmail,
    //   adminId,
    //   adminDob,
    //   adminDoj,
    //   adminLocation,
    //   adminDesignation,
    //   adminConatctNo,
    //   hash,
    // };
    console.log(admin);
    // AdminService.createAdmin(admin)
    //   .then((response) => {
    //     console.log(response.data);
    //     navigate("/");
    //   })
    //   .catch((error) => {
    //     console.log(error);
    //   });
  };

  return (
    <div className="signup-container">
      <div className="custom-form">
        <h2 className="title">Sign Up</h2>
        <form action="">
          <div className="form-section">
            <div className="column">
              <div className="form-group">
                <label>Name</label>
                <input
                  type="text"
                  required
                  className="input"
                  value={adminName}
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
                  value={adminId}
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
                  value={adminDob}
                  onChange={(e) => setDob(e.target.value)}
                />
              </div>

              <div className="form-group">
                <label>DOJ</label>
                <input
                  className="input"
                  type="date"
                  value={adminDoj}
                  onChange={(e) => setDoj(e.target.value)}
                />
              </div>
            </div>
            {/* ///////////////////////////////////////////// */}
            {/* <div className="column">
              <div className="form-group">
                <label>Location</label>
                <input
                  className="input"
                  type="text"
                  value={adminLocation}
                  onChange={(e) => setLocation(e.target.value)}
                />
                <span>{locationError}</span>
              </div> */}
            <div className="column">
              <div className="form-group">
                <label>Location</label>
                <select
                // value={adminlocation}
                type="text"
                placeholder="Enter Location"
                name="location"
                className="input"
                onChange={(e)=>setLocation(e.target.value)}
                >
                  <option value="">Select Location</option>
                  {Location.map((item) => {
                    return (
                      <option key={item} value={item} >
                        {item}
                      </option>
                    );
                  })}
                </select>
              </div>

              {/* <div className="form-group">
                <label>Designation</label>
                <input
                  className="input"
                  type="text"
                  value={adminDesignation}
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
                >
                  <option value="">Select Location</option>
                  {Designation.map((item) => {
                    return (
                      <option key={item} value={item}>
                        {item}
                      </option>
                    );
                  })}
                </select>
              </div>

              <div className="form-group">
                <label>Contact Number</label>
                <input
                  className="input"
                  type="text"
                  value={userConatctNo}
                  onChange={(e) => {
                    setContactNumber(e.target.value);
                  }}
                  onBlur={handlePhoneNo}
                />
                <span>{contactNumberError}</span>
              </div>

              <div className="form-group">
                <label>Password</label>
                <input
                  className="input"
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </div>

              <div className="form-group">
                <label>Password</label>
                <input
                  className="input"
                  type="password"
                  value={confirmPassword}
                  onChange={(e) => {
                    setconfirmPassword(e.target.value);
                  }}
                  onBlur={handlePassword}
                />
              </div>
            </div>
          </div>
          <button
            className="submit-button"
            onClick={(e) => saveAdmin(e)}
            type="submit"
          >
            Sign Up
          </button>
        </form>
      </div>
    </div>
  );
};

export default AdminRegistrationForm;
