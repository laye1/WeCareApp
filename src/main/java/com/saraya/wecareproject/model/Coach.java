package com.saraya.wecareproject.model;

import java.io.Serializable;   
import java.time.LocalDate;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Coach  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int coach_id;
	private String username;
	private String gender;
	private LocalDate date_birth;
	private Long mobile_number;
	private String speciality;
	@OneToMany(mappedBy="coach")
	private List<Appointment> booking;
	
	public Coach() {
		
		super();
	}

	public Coach( String username, String gender, LocalDate date_birth,
			Long mobile_number, String speciality) {
		super();
		
		this.username = username;
		this.gender = gender;
		this.date_birth = date_birth;
		this.mobile_number = mobile_number;
		this.speciality = speciality;
	}

	public int getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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


	public Long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public List<Appointment> getBooking() {
		return booking;
	}

	public void setBooking(List<Appointment> booking) {
		this.booking = booking;
	}

	

	

}
