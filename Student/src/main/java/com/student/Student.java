package com.student;

import java.time.LocalDate;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String section;
	private String gender;
	private int mark1;
	private int mark2;
	private int average;
	private String result;
	
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMark1() {
		return mark1;
	}
	public void setMark1(int mark1) {
		this.mark1 = mark1;
	}
	public int getMark2() {
		return mark2;
	}
	public void setMark2(int mark2) {
		this.mark2 = mark2;
	}
	public String getMark3() {
		return mark3;
	}
	public void setMark3(String mark3) {
		this.mark3 = mark3;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int i) {
		this.total = i;
	}
	private String mark3;
	private int total;
	
}