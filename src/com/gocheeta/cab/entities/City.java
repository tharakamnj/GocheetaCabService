package com.gocheeta.cab.entities;

import javax.validation.constraints.NotBlank;

public class City {
	
	
	private String cityId;
	
	@NotBlank(message = "is required")
	private String cityName;
		
	public City() {
			
		}

	public City(String city_Id) {
		this.cityId = city_Id;
	}
	public City(String city_Id, String city_Name) {
		super();
		this.cityId = city_Id;
		this.cityName = city_Name;
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
		return "City [city_Id=" + cityId + ", city_name=" + cityName + "]";
	}
	
	
	
}