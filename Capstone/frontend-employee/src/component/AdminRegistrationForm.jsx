import React, { useState } from "react";
import AdminService from "../service/AdminService";
import "../style/AdminRegistrationForm.css";
import  {useNavigate} from "react-router-dom";



const AdminRegistrationForm = () => {
  const [admin_name, setName] = useState("");
  const [admin_email, setEmail] = useState("");
  const [admin_id, setId] = useState("");
  const [admin_DOB, setDob] = useState("");
  const [admin_DOJ, setDoj] = useState("");
  const [admin_location, setLocation] = useState("");
  const [admin_designation, setDesignation] = useState("");
  const [admin_contact_no, setContactNumber] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setconfirmPassword] = useState("");

  //ERRORS
  const [errorMessage, setErrorMessage] = useState("");
  const [emailError, setEmailError] = useState("");
  const [empIdError, setEmpIdError] = useState("");
  const [contactNumberError, setContactNumberError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [confirmPasswordError, setConfirmPasswordError] = useState("");

  const navigate= useNavigate();

  //HANDLING ERRORS

  const handleNameBlur = () => {
    if (/^-?\\d/.test(admin_name) || admin_name==="") {
      setErrorMessage("Give valid name");
    }
  };
  const handleEmailBlur = () => {
    if (!admin_email.endsWith("@nucleusteq.com") || admin_email == "") {
      setEmailError("Give valid email id");
      setEmail("");
    }
  };

  const handleEmpIDBlur = () => {
    if (!/^[Nn]\d{3}$/.test(admin_id)) {
      setEmpIdError("Employee ID should be in pattern NXXX");
    } else {
      setEmpIdError("");
    }
  };

  const handlePhoneNo = () => {
    if (!/^\d{10}$/.test(admin_contact_no)) {
      setContactNumberError("Contact no should have 10 digits only");
    } else {
      setContactNumberError("");
    }
  };

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
    if(admin_name==="" || admin_DOB==="" || admin_DOJ==="" || admin_contact_no==="" || admin_designation===""||
    admin_email==="" || admin_id==="" || admin_location==""){
      alert("Complete all fields");
    }
    const admin = {
      admin_name,
      admin_email,
      admin_id,
      admin_DOB,
      admin_DOJ,
      admin_location,
      admin_designation,
      admin_contact_no,
      password,
    };
    AdminService.createAdmin(admin)
      .then((response) => {
        console.log(response.data);
        navigate('/');
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <div id="envelope">
      <form>
        <div className="item">
          <label>Name</label>
          <input
            type="text"
            required
            value={admin_name}
            onChange={(e) => {
              setName(e.target.value);
              setErrorMessage("");
            }
          }
          onBlur={handleNameBlur}
          />
          <span>{errorMessage}</span>
        </div>

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
          <label>Employee id</label>
          <input
            type="text"
            value={admin_id}
            onChange={(e) => {
              setId(e.target.value);
              setEmpIdError("");
            }}
            onBlur={handleEmpIDBlur}
          />
          <span>{empIdError}</span>
        </div>

        <div className="item">
          <label>DOB</label>
          <input
            type="date"
            value={admin_DOB}
            onChange={(e) => setDob(e.target.value)}
          />
        </div>

        <div className="item">
          <label>DOJ</label>
          <input
            type="date"
            value={admin_DOJ}
            onChange={(e) => setDoj(e.target.value)}
          />
        </div>

        <div className="item">
          <label>Location</label>
          <input
            type="text"
            value={admin_location}
            onChange={(e) => setLocation(e.target.value)}
          />
        </div>

        <div>
          <label>Designation</label>
          <input
            type="text"
            value={admin_designation}
            onChange={(e) => setDesignation(e.target.value)}
          />
        </div>

        <div className="item">
          <label>Contact Number</label>
          <input
            type="text"
            value={admin_contact_no}
            onChange={(e) => {setContactNumber(e.target.value)
          }
          }
          onBlur={handlePhoneNo}
          />
          <span>{contactNumberError}</span>
        </div>

        <div className="item">
          <label>Password</label>
          <input type="password" 
          value={password}
          onChange={(e) => setPassword(e.target.value)}/>
        </div>

        <div className="item">
          <label>Password</label>
          <input type="password" 
           value={confirmPassword}
           onChange={(e) => {setconfirmPassword(e.target.value);
             
           }}
           onBlur={handlePassword}
          />
        </div>

        <input id="submit" type="submit" value="Submit" onClick={(e) => saveAdmin(e)} />
      </form>
    </div>
  );
};

export default AdminRegistrationForm;
