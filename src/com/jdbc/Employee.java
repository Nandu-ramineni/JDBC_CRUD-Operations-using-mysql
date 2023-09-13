package com.jdbc;

public class Employee {

	static int id;
	static String Company;
	int  Em_Id;
	String Em_Name;
	Double Salary;
	
	static {
		id = 3000;
		Company = "N-Tech";
	}
	
	public Employee(int Em_Id, String Em_Name, Double Salary) {
		super();
		this.Em_Name = Em_Name;
		this.Em_Id= Em_Id;
		this.Salary = Salary;
	}

}
