// import React, { useEffect, useState } from "react";
// import "../style/AdminDashBoard.css";
// import axios from "axios";

// const DisplayEmployee = () => {
//   const [employees, setEmployees] = useState([]);

//   useEffect(() => {
//     getAllEmployees();
//   }, []);

//   const getAllEmployees =async()=>{
//     try{
//         const response = await axios.get('"http://localhost:8080/user/all/USER');
//         console.log(response.data);
//         setEmployees(response.data)
//     }catch(error){
//         console.log(error)
//     }
//   }
//   return (
//     <div>
//       {/* <div className="navbar">
//         <h2 className="heading">Employee</h2>
//         <h2 className="heading">Manager</h2>
//         <h2 className="heading">Project</h2>
//       </div> */}

//       <div className="container">
//         {employees.map((employee) =>(
//             <div className="box" key={employee.id}>
//           <div className="column">
//             <h4>{employee.name}</h4>
//             <h5>{employee.designation}</h5>
//             <div className="details" >
//               <p>Project name: {employee.project}</p>
//               <p>Manager : {employee.manager}</p>
//               <p>Contact no: {employee.contactNo}</p>
//               <p>Email: {employee.email}</p>
//             </div>
//           </div>

//           <div className="column">
//             <h5>Employee id: {employee.userId}</h5>
//             <p>dob: {employee.dob}</p>
//             <p>doj: {employee.doj}</p>
//             <p>Location : {employee.Location}</p>
//           </div>
//         </div>
//         ) ) }
        
//       </div>
//     </div>
//   );
// };

// export default DisplayEmployee;
import React, { useEffect, useState } from "react";
// import { Link } from "react-router-dom";
import axios from "axios";
//import '../style/DIsplay.css';

const DisplayEmployee = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/user/all/EMPLOYEE"
      );
      console.log(response.data);
      setEmployees(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    
    <div className="container">
      {/* <h2 className="title">List Employees</h2> */}
      {/* <Link to="/addEmployee" className="btn-addEmployee">
        Add Employee
      </Link> */}
      <div className="card-container">
        {employees.map((employee) => (
          <div className="card" key={employee.userId}>
            <div className="column">
            <h2>{employee.name}</h2>
            <p >{employee.designation}</p>
            <p>Project Name : {employee.project}</p>
            <p>Manager : {employee.manager}</p>
            <p>Contact : {employee.contactNo}</p>
            <p>Email : {employee.email}</p>
            </div>
            <div className="column">
                <br></br>
            <p style={{fontSize:"15px"}}>Employee id : {employee.userId}</p>
            <br></br>
            <p>DOB : {employee.dob}</p>
            <p>DOJ: {employee.doj}</p>
            <p>Location : {employee.location}</p>
            </div>
            

          </div>
        ))}
      </div>
    </div>
  );
};

export default DisplayEmployee;
