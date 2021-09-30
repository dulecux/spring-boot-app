package com.dule.springboot.app.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dule.springboot.app.entity.Department;
import com.dule.springboot.app.error.DepartmentNotFoundException;
import com.dule.springboot.app.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	//private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		log.info("Inside saveDepartment of DepartmentController");
		
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Department> fetchDepartmentList() {
		
		log.info("Inside fetchDepartmentList of DepartmentController");
		
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		
		return 	departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		
		departmentService.deleteDepartmentById(departmentId);
		
		return "Department deleted successfully";
		
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		
		return departmentService.updateDepartment(departmentId, department);
		
	}
	
	@GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		
		return departmentService.fetchDepartmentByName(departmentName);
	}

}
