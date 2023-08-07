package com.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.exception.*;
import com.springboot.model.Employee;
import com.springboot.repository.EmployeeRepository;
import com.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

//	@Override
//	public Employee getEmployeeById(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//check if id exists in db or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
			() -> new ResourceNotFoundException("Employee", "Id", id)	);
				
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
	}

	@Override	
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		}else {
			throw new ResourceNotFoundException( "Employee", "Id", id ); 
			
		}
	}

	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Employee", "id", id) ); 
		employeeRepository.deleteById(id);
		
	}
	
	
}
