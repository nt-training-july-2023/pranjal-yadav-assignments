import axios from "axios";
import { ACCEPT_REQUEST, ADD_REQUEST, ALL_REQUESTS, DELETE_REQUEST, IS_REQUESTED, REQUEST_RESOURCE_BASE_URL } from "./ApiUrl";

class RequestResourceService{
      addRequest(request){
        return axios.post(REQUEST_RESOURCE_BASE_URL + ADD_REQUEST, request)
      }
      getAllRequests(){
        return axios.get(REQUEST_RESOURCE_BASE_URL + ALL_REQUESTS)

      }
      deleteRequest(id){
        return axios.delete(REQUEST_RESOURCE_BASE_URL + DELETE_REQUEST + id)
      }
      acceptRequest(id){
        return axios.post(REQUEST_RESOURCE_BASE_URL + ACCEPT_REQUEST + id)
      }
      isRequested(empId, managerid){
        return axios.get(REQUEST_RESOURCE_BASE_URL + IS_REQUESTED + empId + "&managerId=" + managerid)
      }
}
export default new RequestResourceService();