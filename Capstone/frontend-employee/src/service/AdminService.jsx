import axios from "axios";
import {ADMIN_REGISTER,  USER_BASE_URL, LOGIN, ADD_EMPLOYEE, GET_BY_ROLE, ALL_USERS, BY_ID_NAME, BY_ID, ASSIGN, UPDATE_SKILL, UNASSIGN, BY_SKILLS } from "./ApiUrl";

// const URL = 'http://localhost:8080/user/save';
// const LOGIN_URL ='http://localhost:8080/user/login';

class AdminService{
    createAdmin(admin){
        return axios.post(USER_BASE_URL + ADMIN_REGISTER, admin);
    }
    loginAdmin(admin){
        return axios.post(USER_BASE_URL + LOGIN, admin)
    }
    addUser(user) {
        return axios.post(USER_BASE_URL + ADD_EMPLOYEE, user)
    }

    getUserByRole(role){
        return axios.get(USER_BASE_URL + GET_BY_ROLE  + role)
    }
    getAllUsers(){
        return axios.get(USER_BASE_URL + ALL_USERS)
    }
    getEmployeeNameById(employee){
        return axios.get(USER_BASE_URL + BY_ID_NAME + employee.id)
    }
    getUserById(id){
        return axios.get(USER_BASE_URL + BY_ID + id)
    }
    assignProject(id, projectId, managerId) {
        return axios.put(USER_BASE_URL   + ASSIGN+ "/" +id, {
            projectId: projectId,
            managerId: managerId
        })
    }
    updateSkills(id, skills){
        return axios.put(USER_BASE_URL  + UPDATE_SKILL+ "/" + id, skills)
    }
    filter (skills, check) {
        return axios.get(USER_BASE_URL + BY_SKILLS + "?skills="+ skills + "&isCheck=" + check)
    }
    unassign(id){
        return axios.put(USER_BASE_URL + UNASSIGN + id)
    }


    
}

export default new AdminService();