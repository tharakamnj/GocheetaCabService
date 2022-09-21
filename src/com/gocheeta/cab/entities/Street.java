package com.gocheeta.cab.entities;

import javax.validation.constraints.NotBlank;

public class Street {
	
	private String streetId;
	
	@NotBlank(message = "is required")
	private String streetName;
	
	@NotBlank(message = "is required")
	private String cityId;
	
	private String cityName;
	
	public Street() {
		
	}

	public Street(String street_Id) {
		super();
		this.streetId = street_Id;
	}

	public Street(String street_Id, String street_Name,String city_Id) {
		super();
		this.streetId = street_Id;
		this.streetName = street_Name;
		this.cityId = city_Id;
	}

	public Street(String street_Id, String street_Name,String city_Id, String city_Name) {
		super();
		this.streetId = street_Id;
		this.streetName = street_Name;
		this.cityId = city_Id;
		this.cityName = city_Name;
	}

	public String getStreetId() {
		return streetId;
	}

	public void setStreetId(String street_Id) {
		this.streetId = street_Id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String street_Name) {
		this.streetName = street_Name;
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
		return "Street [street_Id=" + streetId + ", street_Name=" + streetName + ", city_Id=" + cityId
				+ ", city_Name=" + cityName + "]";
	}
	
	
	
	
	
	

}
