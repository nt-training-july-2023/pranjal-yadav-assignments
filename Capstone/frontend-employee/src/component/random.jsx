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
                      onChange={(e) => {
                        setName(e.target.value);
                        setErrorMessage("");
                      }}
                    />
                    <span>{errorMessage}</span>
                  </div>
                </div>

                <div className="form-group row mb-2">
                  <label className="col-sm-4 col-form-label">Email</label>
                  <div className="col-sm-8">
                    <input
                      type="email"
                      name="firstName"
                      className="form-control"
                      placeholder="Example: abc@nucleusteq.com"
                      value={admin_email}
                      onChange={(e) => {
                        setEmail(e.target.value);
                        setEmailError("");
                      }}
                      onBlur={handleEmailBlur}
                    />
                    <span>{emailError}</span>
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
                      onChange={(e) => {
                        setId(e.target.value);
                        setEmpIdError("")}}
                      onBlur={handleEmpIDBlur}
                    />
                    <span>{empIdError}</span>
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
                  <label className="col-sm-4 col-form-label">
                    Contact number
                  </label>
                  <div className="col-sm-8">
                    <input
                      type="text"
                      name="firstName"
                      className="form-control"
                      value={admin_contact_no}
                      onChange={(e) => setContactNumber(e.target.value)}
                    />
                  </div>
                  <span>{contactNumberError}</span>
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
                  <label className="col-sm-4 col-form-label">
                    Confirm Password
                  </label>
                  <div className="col-sm-8">
                    <input
                      type="password"
                      name="firstName"
                       className="form-control"
                      value={confirmPassword}
                      onChange={(e) => {setconfirmPassword(e.target.value);
                        
                      }}
                      onBlur={handlePassword}
                    />
                  </div>
                </div>

                <button
                  className="btn btn-success mr-1"
                  onClick={(e) => saveAdmin(e)}
                >
                  Submit
                </button>
                {/* <Link to="/employees" className="btn btn-danger">Cancel</Link> */}
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>


  // return (
  //   <div className="formContainer">
  //   <div className="envelope">
  //     <form>
  //       <div className="item">
  //         <label>Name</label>
  //         <input
  //           type="text"
  //           required
  //           value={admin_name}
  //           onChange={(e) => {
  //             setName(e.target.value);
  //             setErrorMessage("");
  //           }
  //         }
  //         onBlur={handleNameBlur}
  //         />
  //         <span>{errorMessage}</span>
  //       </div>

  //       <div className="item">
  //         <label>Email Id</label>
  //         <input
  //           onChange={(e) => {
  //             setEmail(e.target.value);
  //             setEmailError("");
  //           }}
  //           onBlur={handleEmailBlur}
  //           type="text"
  //         />
  //         <span>{emailError}</span>
  //       </div>

  //       <div className="item">
  //         <label>Employee id</label>
  //         <input
  //           type="text"
  //           value={admin_id}
  //           onChange={(e) => {
  //             setId(e.target.value);
  //             setEmpIdError("");
  //           }}
  //           onBlur={handleEmpIDBlur}
  //         />
  //         <span>{empIdError}</span>
  //       </div>

  //       <div className="item">
  //         <label>DOB</label>
  //         <input
  //           type="date"
  //           value={admin_DOB}
  //           onChange={(e) => setDob(e.target.value)}
  //         />
  //       </div>

  //       <div className="item">
  //         <label>DOJ</label>
  //         <input
  //           type="date"
  //           value={admin_DOJ}
  //           onChange={(e) => setDoj(e.target.value)}
  //         />
  //       </div>

  //       <div className="item">
  //         <label>Location</label>
  //         <input
  //           type="text"
  //           value={admin_location}
  //           onChange={(e) => setLocation(e.target.value)}
  //         />
  //       </div>

  //       <div>
  //         <label>Designation</label>
  //         <input
  //           type="text"
  //           value={admin_designation}
  //           onChange={(e) => setDesignation(e.target.value)}
  //         />
  //       </div>

  //       <div className="item">
  //         <label>Contact Number</label>
  //         <input
  //           type="text"
  //           value={admin_contact_no}
  //           onChange={(e) => {setContactNumber(e.target.value)
  //         }
  //         }
  //         onBlur={handlePhoneNo}
  //         />
  //         <span>{contactNumberError}</span>
  //       </div>

  //       <div className="item">
  //         <label>Password</label>
  //         <input type="password"
  //         value={password}
  //         onChange={(e) => setPassword(e.target.value)}/>
  //       </div>

  //       <div className="item">
  //         <label>Password</label>
  //         <input type="password"
  //          value={confirmPassword}
  //          onChange={(e) => {setconfirmPassword(e.target.value);

  //          }}
  //          onBlur={handlePassword}
  //         />
  //       </div>

  //       <input id="submit" type="submit" value="Register" onClick={(e) => saveAdmin(e)} />
  //     </form>
  //   </div>
  //   </div>
  // );