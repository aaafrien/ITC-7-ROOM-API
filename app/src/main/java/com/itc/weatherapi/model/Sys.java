package com.itc.weatherapi.model;

import com.google.gson.annotations.SerializedName;

public class Sys{

	@SerializedName("country")
	private String country;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	@Override
 	public String toString(){
		return 
			"Sys{" + 
			"country = '" + country + '\'' + 
			"}";
		}
}