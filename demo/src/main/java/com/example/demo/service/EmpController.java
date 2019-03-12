package com.example.demo.service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entity.Emp;

@RestController
@RequestMapping("/emp")
public class EmpController {
	@Autowired
    EmpRepository empRepository;

	// Get All Emps
	@GetMapping("/emps/all")
	public List<Emp> getAllEmpsAll() {
	    return empRepository.findAllByOrderByIdDesc();
	}
	
    // Get All Emps
	@GetMapping("/emps")
	public Page<Emp> getAllEmps(Pageable pageable) {
	    return empRepository.findAll(pageable);
	}
    // Create a new Emp
	@PostMapping("/emps")
	public Emp createEmp(@Valid @RequestBody Emp emp) {
	    return empRepository.save(emp);
	}
    // Get a Single Emp
	@GetMapping("/emps/{id}")
	public Emp getEmpById(@PathVariable(value = "id") Integer id) {
	    return empRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Emp", "id", id));
	}
    // Update a Emp
	@PutMapping("/emps/{id}")
	public Emp updateEmp(@PathVariable(value = "id") Integer empId,  @Valid @RequestBody Emp empDetails) {

		Emp emp = empRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Emp", "id", empId));

		emp.setName(empDetails.getName());
		emp.setEmail(empDetails.getEmail());

	    Emp updatedEmp = empRepository.save(emp);
	    return updatedEmp;
	}
    // Delete a Emp
	@DeleteMapping("/emps/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable(value = "id") Integer empId) {
		Emp emp = empRepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Emp", "id", empId));

		empRepository.delete(emp);

	    return ResponseEntity.ok().build();
	}
}
