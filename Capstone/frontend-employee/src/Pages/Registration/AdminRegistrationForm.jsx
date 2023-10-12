import React, { useState } from "react";
import AdminService from "../../service/AdminService";
import "./AdminRegistrationForm.css";
import { useNavigate, Link } from "react-router-dom";
import Lcn from "../../component/Data/location";
import Desgn from "../../component/Data/designation";
import PopUp from "../../component/PopUp/Popup";
import CustomButton from "../../component/CustomButton";
import InputComponent from "../../component/Input/InputComponent";
import {
  validateName,
  validateEmail,
  validateEmpId,
  validateDob,
  validateDoj,
  validateLocation,
  validateDesignation,
  validateContactNumber,
  validatePassword,
  validateConfirmPassword,
} from '../../component/HandleBlur/HandleBlur'


var bcrypt = require("bcryptjs");

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
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);

  const navigate = useNavigate();

  const saveAdmin = (e) => {
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
      !password ||
      !confirmPassword
    ) {
      validateName(name, setErrorMessage);
      validateEmail(email, setEmailError);
      validateEmpId(userId, setEmpIdError);
      validateDob(dob, setDobError);
      validateDoj(doj, setDojError);
      validateLocation(location, setLocationError);
      validateDesignation(designation, setDesignationError);
      validateContactNumber(
        contactNo,
        setContactNumber,
        setContactNumberError
      );
      validatePassword(password, setPasswordError);
      validateConfirmPassword(
        confirmPassword,
        password,
        setConfirmPasswordError
      );
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
        hashedPassword,
      };
      const admin1 = { ...admin, password: hashedPassword };
      AdminService.createAdmin(admin1)
        .then((response) => {
          if (response.data.responseStatus === 200) {
            setPopUpMessage("Admin Registered");
            setShowPopUp(true);
          }
          navigate("/");
        })
        .catch((error) => {
          setShowPopUp(true);
          setPopUpMessage(error.response.data.message);
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
        <p className="signup_heading">Sign Up</p>
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
                  onBlur={() => validateName(name, setErrorMessage)}
                />
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
                  onBlur={() => validateEmail(email, setEmailError)}
                  type="text"
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
                  onBlur={() => validateEmpId(userId, setEmpIdError)}
                />
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
                  onBlur={() => validateDoj(doj, setDojError)}
                />
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
                  onBlur={() => validateLocation(location, setLocationError)}
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
                  onBlur={() =>
                    validateDesignation(designation, setDesignationError)
                  }
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

                <InputComponent
                  className="input"
                  type="text"
                  value={contactNo}
                  onChange={(e) => {
                    setContactNumber(e.target.value);
                  }}
                  onBlur={() =>
                    validateContactNumber(
                      contactNo,
                      setContactNumber,
                      setContactNumberError
                    )
                  }
                />
                <span>{contactNumberError}</span>
              </div>

              <div className="form-group">
                <label>Password</label>

                <InputComponent
                  className="input"
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  onBlur={() => validatePassword(password, setPasswordError)}
                />
                <span>{passwordError}</span>
              </div>

              <div className="form-group">
                <label>Confirm Password</label>
                <InputComponent
                  className="input"
                  type="password"
                  value={confirmPassword}
                  onChange={(e) => {
                    setconfirmPassword(e.target.value);
                  }}
                  onBlur={() =>
                    validateConfirmPassword(
                      confirmPassword,
                      password,
                      setConfirmPasswordError
                    )
                  }
                />
                <span>{confirmPasswordError}</span>
              </div>
            </div>
          </div>
          <br />
          <CustomButton
            text="Sign Up"
            onClick={(e) => saveAdmin(e)}
            style="submit-button register_btn"
          />
          <Link to="/">Cancel</Link>
        </form>
      </div>
    </div>
  );
};

export default AdminRegistrationForm;
