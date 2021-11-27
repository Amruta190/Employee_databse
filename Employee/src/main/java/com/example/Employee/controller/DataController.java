package com.example.Employee.controller;

import java.util.List;

import com.example.Employee.Entity.Employee;
import com.example.Employee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DataController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployee(@PathVariable("empId") Integer empId){
		return employeeRepo.findById(empId).get();
	}
	
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable("empId") Integer empId){
		employeeRepo.deleteById(empId);
		return "Employee Deleted";
	}
	
	@PostMapping("/employee/{empId}")
	public Employee updateEmployee(@PathVariable("empId") Integer empId, @RequestBody Employee employee){
		Employee employeeFound=employeeRepo.findById(empId).get();
		employeeFound.setDepartment(employee.getDepartment());
		employeeFound.setEmail(employee.getEmail());
		employeeFound.setName(employee.getName());
		employeeFound.setSalary(employee.getSalary());
		return employeeRepo.save(employeeFound);
	}
}
