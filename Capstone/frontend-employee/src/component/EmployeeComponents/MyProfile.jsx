import React, { useEffect, useState } from 'react'
// import '../../style/MyProfile.css'
import './MyProfile.css'

import axios from 'axios';

const MyProfile = () => {
//   useEffect(() => {
//     getEmployee();
//   }, []);
  const [employee, setEmployee] = useState([]);
  // const getEmployee = async () =>{
  //   const empEmail = localStorage.getItem(email);
  //   const response = await axios.get(`http://localhost:8080/user/getEmployee/${empEmail}`)
  //   setEmployee(response.data);
  // }
  return (
    <div>
        <div className='sus'>

        <label htmlFor="Name">Name</label>
        <p>{employee.name}</p>
        </div>
    </div>
  )
}

export default MyProfile