package com.gocheeta.cab.entities;

import javax.validation.constraints.NotBlank;

public class Branch {
	
	private String branchId;
	@NotBlank(message = "is required")
	private String branchName;
	@NotBlank(message = "is required")
	private String cityId;

	private String cityName;
	
	public Branch() {
		
	}
	
	public Branch(String branch_Id) {
		super();
		this.branchId = branch_Id;
	}

	public Branch(String branch_Id, String branch_Name, String city_Id) {
		super();
		this.branchId = branch_Id;
		this.branchName = branch_Name;
		this.cityId = city_Id;
	}

	public Branch(String branch_Id, String branch_Name, String city_Id, String city_Name) {
		super();
		this.branchId = branch_Id;
		this.branchName = branch_Name;
		this.cityId = city_Id;
		this.cityName = city_Name;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branch_Id) {
		this.branchId = branch_Id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branch_Name) {
		this.branchName = branch_Name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String city_Id) {
		this.cityId = city_Id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String city_Name) {
		this.cityName = city_Name;
	}

	@Override
	public String toString() {
		return "branch [branch_Id=" + branchId + ", branch_Name=" + branchName + ", city_Id=" + cityId
				+ ", city_Name=" + cityName + "]";
	}
	
	
}
