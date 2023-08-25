import React, { useState } from "react";
import AdminService from "../service/AdminService";

const AdminRegistrationForm = () => {

    const[admin_name, setName] = useState("");
    const [admin_email, setEmail] = useState("");
    const [admin_id, setId] = useState("");
    const [admin_DOB, setDob] = useState("");
    const [admin_DOJ, setDoj] = useState("");
    const [admin_location, setLocation] = useState("");
    const [admin_designation, setDesignation] = useState("");
    const [admin_contact_no, setContactNumber] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setconfirmPassword] = useState("");

    const saveAdmin =(e) =>{
        e.preventDefault();
        const admin= {admin_name, admin_email,admin_id, admin_DOB, admin_DOJ, admin_location, admin_designation, admin_contact_no, password};
        AdminService.createAdmin(admin).then((response) =>{
            console.log(response.data);
            
        }).catch(error=>{
            console.log(error);
        });
    }
  return (
    <div>
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 ">
            <h4 className="text-center">Admin Register</h4>
            <div className="card-body">
              <form>


                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Name</label>
                  <div className="col-sm-8">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      value={admin_name}
                      onChange={(e) => setName(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Email</label>
                  <div className="col-sm-8">
                    <input
                      type="email"
                      name="firstName"
                      className="form-control"
                      value={admin_email}
                      onChange={(e) => setEmail(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Employee id</label>
                  <div className="col-sm-8">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      value={admin_id}
                      onChange={(e) => setId(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">DOB</label>
                  <div className="col-sm-8">
                    <input
                      type="date"
                      name="firstName"
                      className="form-control"
                      value={admin_DOB}
                      onChange={(e) => setDob(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">DOJ</label>
                  <div className="col-sm-8">
                    <input
                      type="date"
                      name="firstName"
                      className="form-control"
                      value={admin_DOJ}
                      onChange={(e) => setDoj(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Location</label>
                  <div className="col-sm-8">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      value={admin_location}
                      onChange={(e) => setLocation(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Designation</label>
                  <div className="col-sm-8">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      value={admin_designation}
                      onChange={(e) => setDesignation(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Contact number</label>
                  <div className="col-sm-8">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      value={admin_contact_no}
                      onChange={(e) => setContactNumber(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Password</label>
                  <div className="col-sm-8">
                    <input
                      type="password"
                      name="firstName"
                      className="form-control"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                    />
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Confirm Password</label>
                  <div className="col-sm-8">
                    <input
                      type="password"
                      name="firstName"
                      className="form-control"
                      value={confirmPassword}
                      onChange={(e) => setconfirmPassword(e.target.value)}
                    />
                  </div>
                </div>

                <button className="btn btn-success mr-1" onClick={ (e) => saveAdmin(e)}>Submit</button>
                {/* <Link to="/employees" className="btn btn-danger">Cancel</Link> */}
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AdminRegistrationForm;
