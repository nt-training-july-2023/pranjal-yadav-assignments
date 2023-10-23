import axios from "axios";

const URL = 'http://localhost:8080/user/saveEmp';
const getManagerURL = 'http://localhost:8080/user/saveEmp'

class AddEmployeeService {
    createEmp(employee){
        return axios.post(URL, employee);
    }
}

export default new AddEmployeeService();