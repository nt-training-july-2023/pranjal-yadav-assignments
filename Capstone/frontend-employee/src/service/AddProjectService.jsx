import axios from "axios";

const URL = 'http://localhost:8080/project/addProject';
const MANAGER_URL='http://localhost:8080/project/getManagers'

class AddProjectService {
    createProject(project){
        return axios.post(URL, project);
    }
    getAllManagers(){
        const managers = axios.get(MANAGER_URL);
        return managers;
    }
}

export default new AddProjectService();