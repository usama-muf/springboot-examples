package com.usama.restdemo.config;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.usama.restdemo.controller.EmployeeController;
import com.usama.restdemo.entity.Employee;

/**
 * Implements <code>RepresentationModelAssembler</code>
 * it returns EntityModel with modified links
 */


@Controller
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

	@Override
	public EntityModel<Employee> toModel(Employee employee) {

		return EntityModel.of(employee,
				linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
				linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
		
	}

}
