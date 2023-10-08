import React, { useState } from "react";
import AdminService from "../../service/AdminService";
import './AdminRegistrationForm.css'
import { useNavigate } from "react-router-dom";
import Lcn from "../../component/Data/location";
import Desgn from "../../component/Data/designation";
import axios from "axios";
import PopUp from "../../component/PopUp/Popup";
import CustomButton from "../../component/CustomButton";
import InputComponent from "../../component/Input/InputComponent";

var bcrypt = require("bcryptjs");
//var salt = bcrypt.genSaltSync(10);

const AdminRegistrationForm = () => {
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
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);

  const navigate = useNavigate();

  //HANDLING ERRORS

  async function apiCall(reqData) {
    console.log(reqData);
    try {
      const response = await axios.post(
        "http://localhost:8080/user/save",
        reqData
      );
      console.log(response);
      if (response.data.status === 200) {
        console.log(response);
        // alert("admin registered")
      } else {
        setEmailError(response.data.message);
      }
    } catch (error) {
      console.log(error);
      console.log("catch");
    }
  }

  const handleNameBlur = () => {
    if (/^-?\\d/.test(name) || name === "") {
      setErrorMessage("Give valid name");
    }
  };
  const handleEmailBlur = () => {
    if (
      !email.endsWith("@nucleusteq.com") ||
      email == "" ||
      email !== "ankita.sharma@nucleusteq.com"
    ) {
      setEmailError("Give valid email id");
      setEmail("");
    }
  };

  const handleEmpIDBlur = () => {
    if (!/^[N]\d{4}$/.test(userId)) {
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
  const handlePassword = () => {
    if (password !== confirmPassword) {
      setPasswordError("Password and confirm password do not match");
      setConfirmPasswordError("Password and confirm password do not match");
    } else {
      setPasswordError("");
      setConfirmPasswordError("");
    }
  };

  const saveAdmin = (e) => {
    e.preventDefault();
    try {
      if (
        name === "" ||
        dob === "" ||
        doj === "" ||
        contactNo === "" ||
        Desgn === "" ||
        email === "" ||
        userId === "" ||
        Lcn === "" ||
        password === "" ||
        confirmPassword === ""
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
        return;
      }

      const hashedPassword = bcrypt.hashSync(password, 10);

      const admin = {
        name,
        email,
        userId,
        dob,
        doj,
        location,
        designation,
        //contactNo,
        hashedPassword,
      };
      const admin1 = { ...admin, password: hashedPassword };
      AdminService.createAdmin(admin1)
        .then((response) => {
          // console.log(response.data);
          if (response.data.responseStatus === 200) {
            setPopUpMessage("Admin Registered");
            setShowPopUp(true);
          }
          navigate("/");
        })
        .catch((error) => {
          console.log(error);
          //setEmailError(error.response.data.message);
            setShowPopUp(true);
            setPopUpMessage(error.response.data.message);
        });
    } catch (error) {
      //console.log(error.response);
    }
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
        <h2 className="title">Sign Up</h2>
        <form action="">
          <div className="form-section">
            <div className="column">
              <div className="form-group">
                <label>Name</label>
                {/* <input
                  type="text"
                  required
                  className="input"
                  value={name}
                  onChange={(e) => {
                    setName(e.target.value);
                    setErrorMessage("");
                  }}
                  onBlur={handleNameBlur}
                /> */}
                <InputComponent
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
                {/* <input
                  className="input"
                  onChange={(e) => {
                    setEmail(e.target.value);
                    setEmailError("");
                  }}
                  onBlur={handleEmailBlur}
                  type="text"
                /> */}
              <InputComponent
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
                {/* <input
                  type="text"
                  className="input"
                  value={userId}
                  onChange={(e) => {
                    setId(e.target.value);
                    setEmpIdError("");
                  }}
                  onBlur={handleEmpIDBlur}
                /> */}
                <InputComponent
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
                {/* <input
                  type="date"
                  className="input"
                  value={dob}
                  onChange={(e) => setDob(e.target.value)}
                  onBlur={handleDobBlur}
                /> */}
                <InputComponent
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
                {/* <input
                  className="input"
                  type="date"
                  value={doj}
                  onChange={(e) => setDoj(e.target.value)}
                  onBlur={handleDojblur}
                /> */}
                <InputComponent
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
                {/* <input
                  className="input"
                  type="text"
                  value={contactNo}
                  onChange={(e) => {
                    setContactNumber(e.target.value);
                  }}
                  onBlur={handlePhoneNo}
                /> */}
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
                <label>Password</label>
                {/* <input
                  className="input"
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                /> */}
                <InputComponent
                className="input"
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                />
                <span>{passwordError}</span>
              </div>

              <div className="form-group">
                <label>Confirm Password</label>
                {/* <input
                  className="input"
                  type="password"
                  value={confirmPassword}
                  onChange={(e) => {
                    setconfirmPassword(e.target.value);
                  }}
                  onBlur={handlePassword}
                /> */}
                <InputComponent
                className="input"
                type="password"
                value={confirmPassword}
                onChange={(e) => {
                  setconfirmPassword(e.target.value);
                }}
                onBlur={handlePassword}
                />
                <span>{confirmPasswordError}</span>
              </div>
            </div>
          </div>
          <CustomButton text={"Sign Up"}  onClick={(e) => saveAdmin(e)} style={"submit-button"}/>
        </form>
      </div>
    </div>
  );
};

export default AdminRegistrationForm;
