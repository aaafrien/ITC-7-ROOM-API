package com.itc.weatherapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class WeatherResponses{

	@SerializedName("count")
	private int count;

	@SerializedName("cod")
	private String cod;

	@SerializedName("message")
	private String message;

	@SerializedName("list")
	private List<ListItem> list;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setCod(String cod){
		this.cod = cod;
	}

	public String getCod(){
		return cod;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setList(List<ListItem> list){
		this.list = list;
	}

	public List<ListItem> getList(){
		return list;
	}

	@Override
 	public String toString(){
		return 
			"WeatherResponses{" + 
			"count = '" + count + '\'' + 
			",cod = '" + cod + '\'' + 
			",message = '" + message + '\'' + 
			",list = '" + list + '\'' + 
			"}";
		}
}