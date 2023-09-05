import React, { useState } from "react";
import AdminService from "../service/AdminService";
import { Link, useNavigate } from "react-router-dom";
import "../style/AdminRegistrationForm.css";
import { Base64 } from "js-base64";
import PopUp from "./Popup";

const Login = () => {
  const [adminEmail, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);

  const handleEmailBlur = () => {
    if (!adminEmail.endsWith("@nucleusteq.com") || adminEmail == "") {
      setEmailError("Give valid email id");
      setEmail("");
    }
  };
  const handlePasswordBlur = () => {
    if (password === "") {
      setPasswordError("Password is mandatory");
    }
  };

  const logAdmin = (e) => {
    e.preventDefault();
    if (adminEmail === "" || password === "") {
      setEmailError("All fields are mandatory");
      setPasswordError("All fields are mandatory");
    } else {
      const admin = { adminEmail, password };
      const hashedPassword = Base64.encode(password);
      const admin1 = { ...admin, email: adminEmail, password: hashedPassword };
      AdminService.loginAdmin(admin1)
        .then((response) => {
          console.log(response.data);

          setPopUpMessage(response.data.message);
          setShowPopUp(true);
          navigate("/adminDashboard");
        })
        .catch((error) => {
          console.log(error);
          //alert("Login failed");
          // setShowPopUp(true);
          setPopUpMessage(error.response.data.message);
          setShowPopUp(true);
          //setEmailError(error.response.data.message);
        });
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

        <h2 className="title">Admin Login</h2>
        <form>
          {/* <div className="form-section">

      </div> */}

          <div className="form-group">
            <label>Email Id</label>
            <input
              value={adminEmail}
              className="input"
              placeholder=""
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
            <label>Password</label>
            <input
              type="password"
              placeholder=""
              className="input"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              onBlur={handlePasswordBlur}
            />
            <span>{passwordError}</span>
          </div>

          <input
            className="submit-button"
            id="submit"
            type="submit"
            value="Login"
            onClick={(e) => logAdmin(e)}
          />
          <p>
            Or <Link to="/adminRegister">Sign up</Link> instead
          </p>
        </form>
      </div>
    </div>
  );
};

export default Login;
