package com.gocheeta.cab.entities;

import javax.validation.constraints.NotBlank;

public class VehicleCategory {

	private String vehicleCategoryId;
	
	@NotBlank(message = "is required")
	private String vehicleType;
	
	@NotBlank(message = "is required")
	private String serviceCharge;
	
	@NotBlank(message = "is required")
	private String chargePerKm;
	
	
	public VehicleCategory() {
		
	}


	public VehicleCategory(String vehicle_category_Id) {
		super();
		this.vehicleCategoryId = vehicle_category_Id;
	}


	public VehicleCategory(String vehicle_category_Id, String vehicle_type_Name, String service_Charge,
			String charge_per_Km) {
		super();
		this.vehicleCategoryId = vehicle_category_Id;
		this.vehicleType = vehicle_type_Name;
		this.serviceCharge = service_Charge;
		this.chargePerKm = charge_per_Km;
	}


	public String getVehicleCategoryId() {
		return vehicleCategoryId;
	}


	public void setVehicleCategoryId(String vehicle_category_Id) {
		this.vehicleCategoryId = vehicle_category_Id;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicle_type_Name) {
		this.vehicleType = vehicle_type_Name;
	}


	public String getServiceCharge() {
		return serviceCharge;
	}


	public void setServiceCharge(String service_Charge) {
		this.serviceCharge = service_Charge;
	}


	public String getChargePerKm() {
		return chargePerKm;
	}


	public void setChargePerKm(String charge_per_Km) {
		this.chargePerKm = charge_per_Km;
	}


	@Override
	public String toString() {
		return "VehicleCategory [vehicle_category_Id=" + vehicleCategoryId + ", vehicle_type_Name="
				+ vehicleType + ", service_Charge=" + serviceCharge + ", charge_per_Km=" + chargePerKm + "]";
	}
	
	

}
