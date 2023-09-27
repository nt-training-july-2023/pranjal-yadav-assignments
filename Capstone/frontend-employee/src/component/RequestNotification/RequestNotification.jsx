import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import './RequestNotification.css'

const RequestNotification = () => {
  const navigate = useNavigate();
  const [requests, setRequests] = useState([]);
  useEffect(() => {
    getAllRequests();
  }, []);

  const getAllRequests = async () => {
    try {
      const response = await axios.get(
        "http://localhost:8080/user/all/request"
      );
      console.log(response.data);
      setRequests(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  const accept = async (request) => {
    try{
      const response = await axios.post(`http://localhost:8080/user/accept/${request.resourceId}`);
      console.log(response.data);
      window.location.reload()
      // navigate("/requests")
     }
     catch(error){
      console.log(error);
     }
  };
  const reject = (resourceId)=>{
    try{
        axios.delete(`http://localhost:8080/user/request/delete/${resourceId}`)
        window.location.reload()
        // navigate("/requests")
    }catch(error){
        console.log("error deleteing request : "+error);
    }
    
  }
  return (
    <div className="table-container">
      <button onClick={() => {navigate("/adminDashboard")}} style={{background:"red", marginBottom : "8px"}}>Cancel</button>
    <table className="table" border="1">
      <thead>
        <tr>
         
          <th>Employee</th>
          <th>Project Name</th>
          <th>Manager</th>
          <th>Comments</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {requests.map((request) => (
          <tr key={request.resourceId}>
            
            <td>{request.employeeUserId} - {request.employeeName}</td>
            <td>{request.projectName}</td>
            <td>{request.managerUserId} - {request.managerName}</td>
            <td>{request.comment}</td>
            <td>
              <button onClick={() => {accept(request)}} className="accept-button">Accept</button>
              <span><button onClick={()=>{reject(request.resourceId)}} className="reject-button">Reject</button></span>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  </div>
  );
};

export default RequestNotification;
