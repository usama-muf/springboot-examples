package com.usama.restdemo.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usama.restdemo.config.EmployeeModelAssembler;
import com.usama.restdemo.entity.Employee;
import com.usama.restdemo.exception.EmployeeNotFoundException;
import com.usama.restdemo.repo.EmployeeRepo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class EmployeeController {

	private static EmployeeRepo employeeRepo;

	private static EmployeeModelAssembler employeeModelAssembler;

	public EmployeeController(EmployeeRepo employeeRepo, EmployeeModelAssembler employeeModelAssembler) {
		this.employeeRepo = employeeRepo;
		this.employeeModelAssembler = employeeModelAssembler;

	}
	

	@GetMapping("/employees")
	public CollectionModel<EntityModel<Employee>> all() {
//		List<EntityModel<Employee>> employees = employeeRepo.findAll().stream()
//				.map(employee -> EntityModel.of(employee,
//						linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
//						linkTo(methodOn(EmployeeController.class).all()).withRel("Employees")))
//				.collect(Collectors.toList());
		List<EntityModel<Employee>> employees = employeeRepo.findAll().stream()
				.map(employee -> this.employeeModelAssembler.toModel(employee)).collect(Collectors.toList());

//		return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
		return CollectionModel.of(employees);
	}

//	List<Employee> all() {
//		return employeeRepo.findAll();
//	}

	// end::get-aggregate-root[]

	@PostMapping("/employees")
	public ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {
		
		EntityModel<Employee> entityModel = employeeModelAssembler.toModel(employeeRepo.save(newEmployee));
//		return ResponseEntity.ok(entityModel);
		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
		
//		return employeeRepo.save(newEmployee);
	}

	// Single item

	@GetMapping("/employees/{id}")
	public ResponseEntity<EntityModel<Employee>> one(@PathVariable Long id) {

		Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
		
//		Link selfLink = linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel();
//		Link allEmployeeLink = linkTo(methodOn(EmployeeController.class).all()).withRel("employees");
//		EntityModel<Employee> entityModel = EntityModel.of(employee, selfLink, allEmployeeLink);
		
		return new ResponseEntity<EntityModel<Employee>>(employeeModelAssembler.toModel(employee), HttpStatus.OK);

	}

//	Employee one(@PathVariable Long id) {
//		return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
//	}

	@PutMapping("/employees/{id}")
	public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

		return employeeRepo.findById(id).map(employee -> {
			employee.setName(newEmployee.getName());
			employee.setRole(newEmployee.getRole());
			return employeeRepo.save(employee);
		}).orElseGet(() -> {
			newEmployee.setId(id);
			return employeeRepo.save(newEmployee);
		});
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepo.deleteById(id);
	}
	

}
