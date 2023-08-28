import React, { useState } from "react";
import AdminService from "../service/AdminService";
import { Link , useNavigate} from "react-router-dom";
import "../style/AdminRegistrationForm.css";


const Login = () => {

  const [admin_email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");



  const handleEmailBlur = () => {
    if (!admin_email.endsWith("@nucleusteq.com") || admin_email == "") {
      setEmailError("Give valid email id");
      setEmail("");
    }
  };


  const logAdmin =(e) =>{
    e.preventDefault();
    if(admin_email==="" || password===""){
      alert("All fields are mandatory");
    }
    const admin ={admin_email, password};
    AdminService.loginAdmin(admin).then((response) =>{
      console.log(response.data);
      navigate('/dashboard');
    }).catch(error =>{
      console.log(error);
      alert("Login failed");
    });
  }



  return (
    <div id="envelope">
      <h2>Admin Login</h2>
      <form >
      <div className="item">
          <label>Email Id</label>
          <input
            onChange={(e) => {
              setEmail(e.target.value);
              setEmailError("");
            }}
            onBlur={handleEmailBlur}
            type="text"
          />
          <span>{emailError}</span>
        </div>

        <div className="item">
          <label>Password</label>
          <input type="password" 
          value={password}
          onChange={(e) => setPassword(e.target.value)}/>
        </div>

        <input id="submit" type="submit" value="Send Message" onClick={(e) => logAdmin(e)} />
        <p>Or <Link to='/adminRegister'>Sign up</Link> instead</p>
      </form>

    </div>
  );
};

export default Login;
