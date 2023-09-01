import axios from "axios";

const URL = 'http://localhost:8080/user/save';
const LOGIN_URL ='http://localhost:8080/user/login';

class AdminService{
    createAdmin(admin){
        return axios.post(URL, admin);
    }
    loginAdmin(admin){
        return axios.post(LOGIN_URL, admin)
    }
}

export default new AdminService();