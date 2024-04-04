package com.tp.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.lms.model.Student;
import com.tp.lms.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	Student student;

	@GetMapping("")
	public List<Student> getStudent() {

		return studentService.getStudent();

	}

//	@GetMapping("/{studentId}")
//	public ResponseEntity<?> getStudentById(@PathVariable Integer studentId) {
//		
//		if(studentService.validate(student)) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student cannot be empty");
//		}
//
//		Optional<Student> studentO = studentService.getStudentById(studentId);
//		
//
//		if (studentO.isPresent()) {
//			return ResponseEntity.ok(studentO.get());
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + studentId);
//		}
//
//	}

	@PostMapping
	public ResponseEntity<?> addStudent(Student student) {

		return studentService.addStudent(student);

	}

	@PutMapping("/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student student) {

		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable int studentId) {

		return studentService.deleteStudent(studentId);
	}

}
