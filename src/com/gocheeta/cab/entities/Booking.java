package com.gocheeta.cab.entities;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

public class Booking {
	
	private String bookingId ;
	
	private String driverId;
	
	private String customerId;
	
	private String sourceLocation;
	
	@NotBlank(message = "is required")
	private String destinationationLocation;
	
	private String pickupTime;
	private String drop_Time;
	
	@NotBlank(message = "is required")
	private String bookingStatus;
	
	@NotBlank(message = "is required")
	private String vehicleCategoryId;
	
	@NotBlank(message = "is required")
	private Date  bookingDate;
	
	@NotBlank(message = "is required")
	private String cityId;
	

	private String source;
	private String destinationation;
	private String city_Name;
	private String driver_Name;
	private String vehicle_No;
	private String driver_phone_No;
	private String vehicle_type_Name;
	private String customer_Name;
	private String phone_No;
	private String email;
	
	private Double service_Charge;
	
	private Double charge_per_Km;
	
	private Double charges_Calculated;
	
	private Double km_Covered;
	
	public Booking(String booking_Id, String driver_Id, String customer_Id,String source_Location,
			String destinationation_Location, String pickup_Time, String drop_Time,String booking_Status,
			String vehicle_category_Id,Date booking_Date, String city_Id,
			String source, String destinationation, String city_Name, String driver_Name, String vehicle_No,
			String driver_phone_No, String vehicle_type_Name, String customer_Name, String phone_No, String email,Double service_Charge,
			Double charge_per_Km,Double charges_Calculated, Double km_Covered) {
	super();
	this.bookingId = booking_Id;
	this.driverId = driver_Id;
	this.customerId = customer_Id;
	this.sourceLocation = source_Location;
	this.destinationationLocation = destinationation_Location;
	this.pickupTime = pickup_Time;
	this.drop_Time = drop_Time;
	this.bookingStatus = booking_Status;
	this.vehicleCategoryId = vehicle_category_Id;
	this.bookingDate = booking_Date;
	this.cityId = city_Id;
	this.source = source;
	this.destinationation = destinationation;
	this.city_Name = city_Name;
	this.driver_Name = driver_Name;
	this.vehicle_No = vehicle_No;
	this.driver_phone_No = driver_phone_No;
	this.vehicle_type_Name = vehicle_type_Name;
	this.customer_Name = customer_Name;
	this.phone_No = phone_No;
	this.email = email;
	this.service_Charge = service_Charge;
	this.charge_per_Km = charge_per_Km;
	this.charges_Calculated = charges_Calculated;
	this.km_Covered = km_Covered;
}
	
	public Booking(String booking_Id, String driver_Id, String customer_Id,String source_Location,
				String destinationation_Location, String pickup_Time, String drop_Time,String booking_Status,
				String vehicle_category_Id,Date booking_Date, String city_Id,
				String source, String destinationation, String city_Name, String driver_Name, String vehicle_No,
				String driver_phone_No, String vehicle_type_Name, String customer_Name, String phone_No, String email,Double service_Charge,
				Double charge_per_Km) {
		super();
		this.bookingId = booking_Id;
		this.driverId = driver_Id;
		this.customerId = customer_Id;
		this.sourceLocation = source_Location;
		this.destinationationLocation = destinationation_Location;
		this.pickupTime = pickup_Time;
		this.drop_Time = drop_Time;
		this.bookingStatus = booking_Status;
		this.vehicleCategoryId = vehicle_category_Id;
		this.bookingDate = booking_Date;
		this.cityId = city_Id;
		this.source = source;
		this.destinationation = destinationation;
		this.city_Name = city_Name;
		this.driver_Name = driver_Name;
		this.vehicle_No = vehicle_No;
		this.driver_phone_No = driver_phone_No;
		this.vehicle_type_Name = vehicle_type_Name;
		this.customer_Name = customer_Name;
		this.phone_No = phone_No;
		this.email = email;
		this.service_Charge = service_Charge;
		this.charge_per_Km = charge_per_Km;
	}

	public  Booking() {
		
	}

	public Booking(String booking_Id, String customer_Id, String source_Location, String destinationation_Location,
			String booking_Status, String vehicle_category_Id) {
		super();
		this.bookingId = booking_Id;
		this.customerId = customer_Id;
		this.sourceLocation = source_Location;
		this.destinationationLocation = destinationation_Location;
		this.bookingStatus = booking_Status;
		this.vehicleCategoryId = vehicle_category_Id;
	}

	public Booking(String booking_Id, String driver_Id, String customer_Id, String source_Location,
			String destinationation_Location, String pickup_Time, String drop_Time, String booking_Status,
			String vehicle_category_Id,Date booking_Date, String city_Id) {
		super();
		this.bookingId = booking_Id;
		this.driverId = driver_Id;
		this.customerId = customer_Id;
		this.sourceLocation = source_Location;
		this.destinationationLocation = destinationation_Location;
		this.pickupTime = pickup_Time;
		this.drop_Time = drop_Time;
		this.bookingStatus = booking_Status;
		this.vehicleCategoryId = vehicle_category_Id;
		this.bookingDate = booking_Date;
		this.cityId =city_Id;
	}

	public Booking(String booking_Id, String driver_Id, String customer_Id, String source_Location,
			String destinationation_Location, String pickup_Time, String drop_Time, String booking_Status,
			String vehicle_category_Id) {
		super();
		this.bookingId = booking_Id;
		this.driverId = driver_Id;
		this.customerId = customer_Id;
		this.sourceLocation = source_Location;
		this.destinationationLocation = destinationation_Location;
		this.pickupTime = pickup_Time;
		this.drop_Time = drop_Time;
		this.bookingStatus = booking_Status;
		this.vehicleCategoryId = vehicle_category_Id;
	
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String city_Id) {
		this.cityId = city_Id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date booking_Date) {
		this.bookingDate = booking_Date;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String booking_Id) {
		this.bookingId = booking_Id;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driver_Id) {
		this.driverId = driver_Id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customer_Id) {
		this.customerId = customer_Id;
	}

	public String getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(String source_Location) {
		this.sourceLocation = source_Location;
	}

	public String getDestinationationLocation() {
		return destinationationLocation;
	}

	public void setDestinationationLocation(String destinationation_Location) {
		this.destinationationLocation = destinationation_Location;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickup_Time) {
		this.pickupTime = pickup_Time;
	}

	public String getDrop_Time() {
		return drop_Time;
	}

	public void setDrop_Time(String drop_Time) {
		this.drop_Time = drop_Time;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String booking_Status) {
		this.bookingStatus = booking_Status;
	}

	public String getVehicleCategoryId() {
		return vehicleCategoryId;
	}

	public void setVehicleCategoryId(String vehicle_category_Id) {
		this.vehicleCategoryId = vehicle_category_Id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestinationation() {
		return destinationation;
	}

	public void setDestinationation(String destinationation) {
		this.destinationation = destinationation;
	}

	public String getCity_Name() {
		return city_Name;
	}

	public void setCity_Name(String city_Name) {
		this.city_Name = city_Name;
	}

	public String getDriver_Name() {
		return driver_Name;
	}

	public void setDriver_Name(String driver_Name) {
		this.driver_Name = driver_Name;
	}

	public String getVehicle_No() {
		return vehicle_No;
	}

	public void setVehicle_No(String vehicle_No) {
		this.vehicle_No = vehicle_No;
	}

	public String getDriver_phone_No() {
		return driver_phone_No;
	}

	public void setDriver_phone_No(String driver_phone_No) {
		this.driver_phone_No = driver_phone_No;
	}

	public String getVehicle_type_Name() {
		return vehicle_type_Name;
	}

	public void setVehicle_type_Name(String vehicle_type_Name) {
		this.vehicle_type_Name = vehicle_type_Name;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getService_Charge() {
		return service_Charge;
	}

	public void setService_Charge(Double service_Charge) {
		this.service_Charge = service_Charge;
	}

	public Double getCharge_per_Km() {
		return charge_per_Km;
	}

	public void setCharge_per_Km(Double charge_per_Km) {
		this.charge_per_Km = charge_per_Km;
	}

	public Double getCharges_Calculated() {
		return charges_Calculated;
	}

	public void setCharges_Calculated(Double charges_Calculated) {
		this.charges_Calculated = charges_Calculated;
	}

	public Double getKm_Covered() {
		return km_Covered;
	}

	public void setKm_Covered(Double km_Covered) {
		this.km_Covered = km_Covered;
	}
	
	
	

}
