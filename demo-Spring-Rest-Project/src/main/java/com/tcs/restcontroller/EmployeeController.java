/**
 * 
 */
package com.tcs.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.tcs.dao.EmployeeDao;
import com.tcs.model.Employee;

/**
 * @author springuser01
 *
 */
@RestController
public class EmployeeController {
	@Autowired //The meaning of @Autowired is put the dependency injection at the Dao layer
	private EmployeeDao employeeDAO;

	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/employees")
		@ResponseBody
		public List getEmployee() {
		

		
		return employeeDAO.list();
	}
	
	
	//get
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.GET,
		    value = "/employees/{id}")
		@ResponseBody
	public ResponseEntity getCustomer(@PathVariable("id") Long id) {

		Employee employee = employeeDAO.get(id);
		if (employee == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(employee, HttpStatus.OK);
	}

//post
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.POST,
		    value = "/post/employees")
	@ResponseBody
	public ResponseEntity createEmployee(@RequestBody Employee employee) {

		employeeDAO.create(employee);

		return new ResponseEntity(employee, HttpStatus.OK);
	}
	
//delete
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.DELETE,
		    value = "/delete/employees/{id}")
	@ResponseBody
	
	public ResponseEntity deleteEmployee(@PathVariable Long id) {

		if (null == employeeDAO.delete(id)) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}
	
//put
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, 
		    method = RequestMethod.PUT,
		    value = "/put/employees/{id}")
	@ResponseBody
	
	
	public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

		employee = employeeDAO.update(id, employee);

		if (null == employee) {
			return new ResponseEntity("No Employee found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(employee, HttpStatus.OK);
	}




}