package com.gocheeta.cab.entities;

import javax.validation.constraints.NotBlank;

public class Employee {
	private String employeeId;
	@NotBlank(message = "is required")
	private String username;
	@NotBlank(message = "is required")
	private String password;
	@NotBlank(message = "is required")
	private String email;
	@NotBlank(message = "is required")
	private String displayName;
	
	@NotBlank(message = "is required")
	private String userType;
	
    public Employee() {
		
	}

	public Employee(String employee_Id) {
		super();
		this.employeeId = employee_Id;
	}

	public Employee(String employee_Id, String username, String password, String email, String display_Name,String userType) {
		super();
		this.employeeId = employee_Id;
		this.username = username;
		password = password;
		this.email = email;
		this.displayName = display_Name;
		this.userType = userType;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employee_Id) {
		this.employeeId = employee_Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String display_Name) {
		this.displayName = display_Name;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
