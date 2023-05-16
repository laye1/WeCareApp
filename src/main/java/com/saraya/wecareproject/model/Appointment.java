 package com.saraya.wecareproject.model;

import java.io.Serializable; 
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Appointment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int booking_id;
	private LocalDate appointment_date;
	private String slot;
	@ManyToOne
	@JoinColumn(name="code_coach")
	private Coach coach ;
	@ManyToOne
	@JoinColumn(name="code_user")
	private User user;
	
	public Appointment(){
		
		super();
	}

	public Appointment(int booking_id, LocalDate appointment_date, String slot) {
		super();
		this.booking_id = booking_id;
		this.appointment_date = appointment_date;
		this.slot = slot;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public LocalDate getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(LocalDate appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
