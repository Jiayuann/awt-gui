package com.knight.collection2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	
	private int id;
	private String name;
	private int salary;
	private Date date;
	
	public Employee(int id, String name, int salary, String date) throws Exception {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		DateFormat format=new SimpleDateFormat("yyyy-MM");
		this.date=format.parse(date);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


}

