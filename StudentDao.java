package com.vp.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.vp.model.Student;

public class StudentDao {
	static List<Student> list =null;
	static {		
		list = new ArrayList<Student>(); 
		list.add(new Student(1, "Anil", "Mang"));
		list.add(new Student(2, "Aji", "Mang2"));
		list.add(new Student(3, "Sanal", "Pralin"));
		list.add(new Student(4, "Nibin", "Raj"));
	}
	public List<Student> getStudents(){		
		
		return StudentDao.list;
	}	
	public ResponseEntity<Student> insertStudent(Student student){
		list.add(student);		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	public ResponseEntity<Student> getStudent(int id){
		for (Student student : list) {
			if(student.getStudentid() == id) {
				return new ResponseEntity<Student>(student, HttpStatus.OK);
			}
		}
		return null;
	}
	public int deleteStudent(int id){
		for (Student student : list) {
			if(student.getStudentid() == id) {
				list.remove(student);
				return id;
			}
		}
		return 0;
	}

}
