package com.cts.eaution.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class UserDocument  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3454905156300037102L;
	
	@Id
	private Long id;
	private String email;
	private String role;
	private Date createdDate;
	private UserDetailDocument userDetail;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public UserDetailDocument getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetailDocument userDetail) {
		this.userDetail = userDetail;
	}
}
