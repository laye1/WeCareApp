package com.saraya.wecareproject.service;

import java.time.LocalDateTime;  
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saraya.wecareproject.model.Appointment;
import com.saraya.wecareproject.model.Coach;
import com.saraya.wecareproject.model.User;
import com.saraya.wecareproject.repository.AppointmentRepository;
import com.saraya.wecareproject.repository.CoachRepository;
import com.saraya.wecareproject.repository.UserRepository;
import com.saraya.wecareproject.token.ConfirmationToken;
import com.saraya.wecareproject.token.ConfirmationTokenService;



@Service("userService")
public class UserService implements UserDetailsService{
	
	private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

	@Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ConfirmationTokenService confirmationTokenService;
	
    @Autowired
	private  CoachRepository coachRepository ; 
    @Autowired
	private  UserRepository userRepository;
    @Autowired
	private  AppointmentRepository AppointRepo;
	
	
	public List<Coach> fetchAllCoach(){
		
		return coachRepository.findAll();
			
		}
	
	public List<User> fetchAllUser(){
			
			return userRepository.findAll();
				
			}
	
	public List<Appointment> fetchAllAppointment(){
		
		return AppointRepo.findAll();
			
		}
	
	public String createCoach(Coach coach) {
		 coachRepository.save(coach);
		 return "Coach"+ coach.getCoach_id()+"addeed succesfully";
	}
	
	public String createUser(User user) {
		 userRepository.save(user);
		 return "Coach addeed succesfully";
	}
	
	public String createAppointment(Appointment appointment) {
		AppointRepo.save(appointment);
		 return "Coach"+ appointment.getBooking_id()+"addeed succesfully";
	}
	public String deleteAppointment(int id) {
		 AppointRepo.deleteById(id);
		 return "Appointment deleted succesfully";
	}
	
	public Coach getCoachProfile(int id) {
		
		return coachRepository.getById(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
	}
	
	
	
	public String signUpUser(User user) {
        boolean userExists = userRepository
                .findByEmail(user.getEmail())
                .isPresent();

        if (userExists) {
            

            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder
                .encode(user.getPassword());
        
        

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableUser(String email) { 
        return userRepository.enableUser(email);
    }
  
}
