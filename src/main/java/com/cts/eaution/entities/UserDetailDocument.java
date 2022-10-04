package com.cts.eaution.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author aadi
 *No sql document for user details
 */
@Document("user-details")
public class UserDetailDocument implements Serializable{
	
	public UserDetailDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static final long serialVersionUID = -5340141745534799192L;
	@Id
	private Long userDetailId;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String country;
	
	public Long getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(Long userDetailId) {
		this.userDetailId = userDetailId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
