import React, { useState } from "react";
import AdminService from "../../service/AdminService"
import { Link, useNavigate } from "react-router-dom";
import { Base64 } from "js-base64";
import PopUp from "../../component/PopUp/Popup";
import Input from "../../component/Input/InputComponent";
import { validateEmployeeEmail } from '../../component/HandleBlur/HandleBlur'

const Login = () => {
  const [adminEmail, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [popMessage, setPopUpMessage] = useState("");
  const [showPopUp, setShowPopUp] = useState(false);

  const handleEmailBlur = () => {
    if (!adminEmail.endsWith("@nucleusteq.com") || adminEmail === "") {
      setEmailError("Give valid email id");
      setEmail("");
      return
    }
  };
  const handlePasswordBlur = () => {
    if (password === "") {
      setPasswordError("Password is mandatory");
      return
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
          setPopUpMessage(response.data.message);
          setShowPopUp(true);

          if(response.data.role === "ADMIN") navigate('/adminDashboard');
          if(response.data.role === "EMPLOYEE") navigate('/employeeDashboard');
          if(response.data.role === "MANAGER") navigate('/managerDashboard');
          localStorage.setItem("userRole", response.data.role);
          localStorage.setItem("isLoggedIn", response.status);
          localStorage.setItem("email", admin1.email);
          localStorage.setItem("name", response.data.name)
          localStorage.setItem("id", response.data.id)

        })
        .catch((error) => {
          setPopUpMessage(error.response.data.message);
          setShowPopUp(true);
        });
    }
  };

  return (
    <div className="signup-container">
      <div className="custom-form login-form">
        {showPopUp && (
          <PopUp
            message={popMessage}
            onClose={() => {
              setShowPopUp(false);
            }}
          />
        )}

        <h2 className="title">Login</h2>
        <form>

          <div className="form-group">
            <label>Email Id</label>
            
            <Input 
            id="login-input-email"
            value={adminEmail}
            className="input"
            placeholder=""
            onChange={(e) => {
              setEmail(e.target.value);
              setEmailError("");
            }}
            onBlur={() => validateEmployeeEmail(adminEmail, setEmailError)}
            type="text"
            />
            
            <span className="error_invalid">
              <br />
              {emailError}</span>
          </div>
          <div className="form-group">
            <label>Password</label>

            <Input
            id="login-input-pswd"
            type="password"
            placeholder=""
            className="input"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            onBlur={handlePasswordBlur}
            />
            <span className="error_invalid">
              <br />
              {passwordError}</span>
          </div>

          <input
            className="submit-button"
            id="submit"
            type="submit"
            value="Login"
            onClick={(e) => logAdmin(e)}
          />
          <p className="para">
            Or <Link to="/adminRegister">Sign up</Link> instead
          </p>
        </form>
      </div>
    </div>
  );
};

export default Login;
