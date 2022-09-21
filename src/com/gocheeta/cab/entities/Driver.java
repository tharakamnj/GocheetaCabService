package com.gocheeta.cab.entities;

import javax.validation.constraints.NotBlank;

public class Driver {
	private String driverId;
	
	@NotBlank(message = "is required")
	private String branchId;
	
	@NotBlank(message = "is required")
	private String vehicleCategoryId;
	
	@NotBlank(message = "is required")
	private String driverName;
	
	@NotBlank(message = "is required")
	private String phoneNo;
	
	@NotBlank(message = "is required")
	private String address;
	
	@NotBlank(message = "is required")
	private String licenceNo;
	
	@NotBlank(message = "is required")
	private String password;
	
	@NotBlank(message = "is required")
	private String vehicleNo;
	
	private String vehicleTypeName;
	
	private String branchName;
	
	public Driver() {
		
	}

	public Driver(String driver_Id) {
		super();
		this.driverId = driver_Id;
	}

	public Driver(String driver_Id, String branch_Id, String vehicle_category_Id, String driver_Name, String phone_No,
			String address, String licence_No, String password, String vehicle_No) {
		super();
		this.driverId = driver_Id;
		this.branchId = branch_Id;
		this.vehicleCategoryId = vehicle_category_Id;
		this.driverName = driver_Name;
		this.phoneNo = phone_No;
		this.address = address;
		this.licenceNo = licence_No;
		this.password = password;
		this.vehicleNo = vehicle_No;
	}
	
	
	

	public Driver(String driver_Id, String branch_Id,
			String vehicle_category_Id, String driver_Name, String phone_No, String address,String licence_No,String password, String vehicle_No,
			String vehicle_type_Name, String branch_Name) {
		super();
		this.driverId = driver_Id;
		this.branchId = branch_Id;
		this.vehicleCategoryId = vehicle_category_Id;
		this.driverName = driver_Name;
		this.phoneNo = phone_No;
		this.address = address;
		this.licenceNo = licence_No;
		this.password = password;
		this.vehicleNo = vehicle_No;
		this.vehicleTypeName = vehicle_type_Name;
		this.branchName = branch_Name;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriver_ID(String driver_ID) {
		this.driverId = driver_ID;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranch_ID(String branch_Id) {
		this.branchId = branch_Id;
	}

	public String getvehicle_category_Id() {
		return vehicleCategoryId;
	}

	public void setVehicle_Category_Id(String vehicle_category_Id) {
		this.vehicleCategoryId = vehicle_category_Id;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driver_Name) {
		this.driverName = driver_Name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phone_No) {
		this.phoneNo = phone_No;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licence_No) {
		this.licenceNo = licence_No;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicle_No) {
		this.vehicleNo = vehicle_No;
	}
	
	

	public String getVehicleTypeName() {
		return vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicle_type_Name) {
		this.vehicleTypeName = vehicle_type_Name;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branch_Name) {
		this.branchName = branch_Name;
	}

	@Override
	public String toString() {
		return "Driver [driver_Id=" + driverId + ", branch_Id=" + branchId + ", vehicle_category_Id="
				+ vehicleCategoryId + ", driver_Name=" + driverName + ", phone_No=" + phoneNo + ", address="
				+ address + ", licence_No=" + licenceNo + ", password=" + password + ", vehicle_No=" + vehicleNo
				+ "]";
	}
	
	
}
