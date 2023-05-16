package com.saraya.wecareproject.registration;

import java.time.LocalDate;  

import com.saraya.wecareproject.model.UserRole;




//@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
public class RegistrationRequest {
	String name;
	String gender;
	LocalDate date_birth;
	String email;
	String password;
	Long mobile_number;
    String city;
	String state;
	String country;
	UserRole userRole;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDate_birth() {
		return date_birth;
	}
	public void setDate_birth(LocalDate date_birth) {
		this.date_birth = date_birth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
}
