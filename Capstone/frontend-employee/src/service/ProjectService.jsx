import axios from "axios";
import { ADD_PROJECT, ALL_PROJECTS, GET_MANAGERS, PROJECT_BASE_URL, PROJECT_BY_MANAGERID } from "./ApiUrl";

class ProjectService {
    createProject(project) { 
        return axios.post(PROJECT_BASE_URL + ADD_PROJECT, project)
    }
    getAllProjects(){
        return axios.get(PROJECT_BASE_URL + ALL_PROJECTS)
    }
    getManagers(){
        return axios.get(PROJECT_BASE_URL + GET_MANAGERS)
    }
    getProjectByManagerId(id){
        return  axios.get(PROJECT_BASE_URL + PROJECT_BY_MANAGERID +id)
    }
}
export default new ProjectService();