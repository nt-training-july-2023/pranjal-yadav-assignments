import React, { useState } from "react";
import AdminService from "../service/AdminService";
import { Link , useNavigate} from "react-router-dom";
import "../style/AdminRegistrationForm.css";


const Login = () => {

  const [adminEmail, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");



  const handleEmailBlur = () => {
    if (!adminEmail.endsWith("@nucleusteq.com") || adminEmail == "") {
      setEmailError("Give valid email id");
      setEmail("");
    }
  };


  const logAdmin =(e) =>{
    e.preventDefault();
    if(adminEmail==="" || password===""){
      alert("All fields are mandatory");
    }
    const admin ={adminEmail, password};
    AdminService.loginAdmin(admin).then((response) =>{
      console.log(response.data);
      navigate('/dashboard');
    }).catch(error =>{
      console.log(error);
      alert("Login failed");
    });
  }



  return (

    <div className="signup-container">
      <div className="custom-form">

     
      <h2 className="title">Admin Login</h2>
      <form >

    {/* <div className="form-section">

      </div> */}

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
          <label>Password</label>
          <input type="password" 
          className="input"
          value={password}
          onChange={(e) => setPassword(e.target.value)}/>
        </div>

        <input id="submit" type="submit" value="Login" onClick={(e) => logAdmin(e)} />
        <p>Or <Link to='/adminRegister'>Sign up</Link> instead</p>
      </form>
            </div>
    </div>
  );
};

export default Login;
