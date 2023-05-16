package com.saraya.wecareproject.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.wecareproject.model.Appointment;
import com.saraya.wecareproject.model.Coach;
import com.saraya.wecareproject.model.User;
import com.saraya.wecareproject.service.UserService;



@RestController
@RequestMapping("/coach")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add-user",consumes="application/json")
	public ResponseEntity<String> createUser(@RequestBody User user){
		
		String response = userService.createUser(user);
		
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping(value="/add-coach",consumes="application/json")
	public ResponseEntity<String> createCoach(@RequestBody Coach coach) {
		
		String response = userService.createCoach(coach);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping(value="/add-booking",consumes="application/json")
	public ResponseEntity<String> createAppointment(@RequestBody Appointment appoint) {
		
		String response = userService.createAppointment(appoint);
		
		return ResponseEntity.ok(response);
		
	}
	@PostMapping(value="/delete-booking/{id}",consumes="application/json")
	public ResponseEntity<String> deleteAppointment(@PathVariable("id") int id) {
		
		String response = userService.deleteAppointment(id);
		
		return ResponseEntity.ok(response);
		
	}
	
	
	@GetMapping(value="/all-coach",produces="application/json")
	public List<Coach> getAllCoach(){
		
		return userService.fetchAllCoach();
		
		}
	
	@GetMapping(value="/all-user",produces="application/json")
	public List<User> getAllUser(){
		
		return userService.fetchAllUser();
		
	}
	

	@GetMapping(value="/all-booking",produces="application/json")
	public List<Appointment> getAllBooking(){
		
		return userService.fetchAllAppointment();
		
	}
	
	@GetMapping(value="/find/{id}",produces="application/json")
	public ResponseEntity<Coach> getCoachProfile(@PathVariable("id") int id){
		
		Coach coachs = userService.getCoachProfile(id);
		
		return new ResponseEntity<>(coachs,HttpStatus.OK);
		
	
		
	}

}
