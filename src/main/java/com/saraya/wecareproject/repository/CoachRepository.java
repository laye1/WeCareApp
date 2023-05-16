package com.saraya.wecareproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saraya.wecareproject.model.Coach;

public interface CoachRepository extends JpaRepository<Coach, Integer>{
	
	public Coach findById(int id);

}
