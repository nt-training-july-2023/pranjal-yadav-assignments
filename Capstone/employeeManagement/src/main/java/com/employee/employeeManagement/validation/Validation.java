package com.employee.employeeManagement.validation;

import com.employee.employeeManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class Validation {

    public final boolean validEmptyData(final String data) {
        if (data.isEmpty()) {
            return true;
        }
        return false;
    }
    public boolean checkName(String name){
        String regex = "^[a-zA-Z\\s]+$";
        if(name.matches(regex)){
            return true;
        }
        return false;
    }

    public boolean checkEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@nucleusteq\\.com$";
        if(email.matches(regex)){
            return true;
        }
        return false;
    }
    public boolean checkPhone(Long ContactNo){
        String regex = "^[0-9]{10}$";
        String phoneString = Long.toString(ContactNo);
        if(phoneString.matches(regex)){
            return true;
        }
        return false;
    }

    public boolean checkId(String id){
        String regex = "^[Nn]\\d{3}$";
        if(id.matches(regex)){
            return true;
        }
        return false;
    }
}
