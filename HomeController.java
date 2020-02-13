package com.vp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vp.dao.StudentDao;
import com.vp.model.Student;

@RestController
public class HomeController {
	
	@Autowired
	StudentDao dao;
   
	@RequestMapping("/homedata")
	public ResponseEntity<Student> getHomeData() {
		
		return new ResponseEntity<Student>(new Student(11,"Giri", "Add1111"), HttpStatus.OK);
			
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getStudent(){
				
		return dao.getStudents();
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		return (ResponseEntity<Student>) dao.getStudent(id);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveUser(@RequestBody Student student) {
		return (ResponseEntity<com.vp.model.Student>) dao.insertStudent(student);
	}
	
	@DeleteMapping("student/{id}")
	public int deleteStudent(@PathVariable("id") int id) {
		return dao.deleteStudent(id);
	}
}