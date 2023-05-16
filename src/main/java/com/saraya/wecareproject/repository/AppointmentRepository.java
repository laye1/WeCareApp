package com.saraya.wecareproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.wecareproject.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
	
}
