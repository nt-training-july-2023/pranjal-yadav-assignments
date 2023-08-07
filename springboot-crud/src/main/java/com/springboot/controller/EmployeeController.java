package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeservice;
	
	
	
	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	//build create employee restApi
	@PostMapping
	public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	
	//get all employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeservice.getAllEmployee();
	}
	
	//get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById( @PathVariable("id")  long employeeid){
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(employeeid), HttpStatus.OK);
	}
	
	//updating employee
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, 
													@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	
	//delete employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeservice.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}
	
}





