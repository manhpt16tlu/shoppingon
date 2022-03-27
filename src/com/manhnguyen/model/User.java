package com.manhnguyen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

	private int id;
	private String fullname;
	private String email;
	private String pass;
	private String phone;

//	public User() {
//	}
//
//	public User(int id, String fullname, String email, String pass, String phone) {
//		this.id = id;
//		this.fullname = fullname;
//		this.email = email;
//		this.pass = pass;
//		this.phone = phone;
//	}
//
//	public User(String fullname, String email, String pass, String phone) {
//		this.fullname = fullname;
//		this.email = email;
//		this.pass = pass;
//		this.phone = phone;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getFullname() {
//		return fullname;
//	}
//
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPass() {
//		return pass;
//	}
//
//	public void setPass(String pass) {
//		this.pass = pass;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", pass=" + pass + ", phone=" + phone
//				+ "]";
//	}
}
