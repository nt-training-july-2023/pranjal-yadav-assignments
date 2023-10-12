import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import "./RequestNotification.css";
import Popup from "../PopUp/Popup";
import RequestResourceService from "../../service/RequestResourceService";
import CustomButton from "../CustomButton";
import NoContent from "../NoContent/NoContent";

const RequestNotification = () => {
  const navigate = useNavigate();
  const [message, setMessage] = useState("");
  const [isPopupOpen, setIsPopupOpen] = useState(false);
  const [showRequestStatusPopup, setShowRequestStatusPopup] = useState(false);
  const [requestStatusMessage, setRequestStatusMessage] = useState('');
  const [requests, setRequests] = useState([]);
  useEffect(() => {
    getAllRequests();
  }, []);

  const getAllRequests = async () => {
    try {
      RequestResourceService.getAllRequests().then((response) => {
        setRequests(response.data);
      });
    } catch (error) {
    }
  };
  const accept = async (request,employeeName) => {
    try {
      const response = await axios.post(
        `http://localhost:8080/user/accept/${request.resourceId}`
        
      );
      setRequestStatusMessage(`Request accepted for ${employeeName}`);
      setShowRequestStatusPopup(true);
      getAllRequests();
    } catch (error) {
      setIsPopupOpen(true);
      setMessage(error.response.data.message);
    }
  };
  const reject = (resourceId,employeeName) => {
    try {
      axios.delete(`http://localhost:8080/user/request/delete/${resourceId}`);
      setRequestStatusMessage(`Request rejected for ${employeeName}`);
      setShowRequestStatusPopup(true);
      getAllRequests();
    } catch (error) {
    }
  };
  return (
    <div className="table-container">
    
      <CustomButton
        text={"Cancel"}
        onClick={() => {
          navigate("/adminDashboard");
        }}
        style="btn-cancel"
      />
      <div className="rr_heading">REQUEST RESOURCE TABLE</div>
      {requests.length === 0 ? (
        <NoContent />
      ) : (
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
                <td>
                  {request.employeeUserId} - {request.employeeName}
                </td>
                <td>{request.projectName}</td>
                <td>
                  {request.managerUserId} - {request.managerName}
                </td>
                <td>{request.comment}</td>
                <td>
                  <button
                    onClick={() => {
                      accept(request, request.employeeName);  
                                  
                    }}
                    className="accept-button"
                  >
                    Accept
                  </button>
                  <span>
                    <button
                      onClick={() => {
                        reject(request.resourceId, request.employeeName);
                      }}
                      className="reject-button"
                    >
                      Reject
                    </button>
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
      {showRequestStatusPopup && (
        <Popup
          message={requestStatusMessage}
          onClose={() => {
            setShowRequestStatusPopup(false);
            setRequestStatusMessage('');
            window.location.reload();
          }}
          />
      )}
    </div>
  );
};

export default RequestNotification;
