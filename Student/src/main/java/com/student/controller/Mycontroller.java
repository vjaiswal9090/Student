package com.student.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.Student;
import com.student.service.StudentService;


@RestController
public class Mycontroller {
	@Autowired
	StudentService studentService;
	@PostMapping("/students")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
	    // Perform validations
	    if (student.getFirstName().length() < 3 || student.getLastName().length() < 3) {
	        return ResponseEntity.badRequest().body("First and last names must be at least 3 characters long.");
	    }
	    
	 // Validate DOB
	    LocalDate currentDate = LocalDate.now();
	    LocalDate dob = student.getDob();
	    if (dob == null || dob.isAfter(currentDate.minusYears(15)) || dob.isEqual(currentDate) || dob.isBefore(currentDate.minusYears(20))) {
	        return ResponseEntity.badRequest().body("Invalid DOB. Age should be greater than 15 and less than or equal to 20 years.");
	    }
	 // Validate marks
	    if (student.getMark1() < 0 || student.getMark1() > 100 ||
	        student.getMark2() < 0 || student.getMark2() > 100) {
	        return ResponseEntity.badRequest().body("Marks should be in the range of 0 to 100.");
	    }
	    
	 // Set total, average, and result automatically
	    student.setTotal(student.getMark1() + student.getMark2());
	    student.setAverage(student.getTotal() / 2);
	    student.setResult(student.getMark1() >= 35 && student.getMark2() >= 35 ? "Pass" : "Fail");

	    // Save the student using the StudentService
	    studentService.createStudent(student);

	    return ResponseEntity.ok("Student created successfully.");
	
}
	@PutMapping("/students/{id}/marks")
	public ResponseEntity<String> updateStudentMarks(@PathVariable("id") String id, @RequestParam("mark1") int mark1,
	        @RequestParam("mark2") int mark2) {
	    // Find the student by ID using the StudentService
	    Student student = studentService.getStudentById(id);

	    // Perform validations
	    if (mark1 < 0 || mark1 > 100 ||
	        mark2 < 0 || mark2 > 100 ) {
	       return  ResponseEntity.badRequest().body("Marks should be in the range of 0 to 100.");
	    }
		return  ResponseEntity.ok("student marks");

	}
}
