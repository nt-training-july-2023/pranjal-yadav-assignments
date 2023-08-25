import axios from "axios";

const URL = 'http://localhost:8080/api/save';

class AdminService{
    createAdmin(admin){
        return axios.post(URL, admin);
    }
}

export default new AdminService();