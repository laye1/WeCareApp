package com.saraya.wecareproject.model;

import java.io.Serializable;   
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="user")
public class User implements UserDetails, Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String name;
	@Column(nullable=true)
	private String gender;
	@Column(nullable=true)
	private LocalDate date_birth;
	private String email;
	private String password;
	@Column(nullable=true)
	private Long mobile_number;
	@Column(nullable=true)
	private String city;
	@Column(nullable=true)
	private String state;
	private Boolean locked =false;
	private Boolean enabled =false;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	@Column(nullable=true) 
	private String country;
	@OneToMany(mappedBy="user")
	private List<Appointment> booking;
	
	public User() {
		super();
		
	}

	public User( String name, String gender, LocalDate date_birth,String email, String password, Long mobile_number,
			  String city, String state, String country,UserRole userRole) {
		super();
		
		this.name = name;
		this.gender = gender;
		this.date_birth = date_birth;
		this.password = password;
		this.mobile_number = mobile_number;
		this.email = email; 
	
		this.city = city;
		this.state = state;
		this.country = country;
		this.userRole = userRole;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

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

	public List<Appointment> getBooking() {
		return booking;
	}
	

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public void setBooking(List<Appointment> booking) {
		this.booking = booking;
	}
      
	



	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", date_birth=" + date_birth + ", password=" + password
				+ ", mobile_number=" + mobile_number + ", email=" + email + ", city=" + city
				+ ", state=" + state + ", locked=" + locked + ", enable=" + enabled + ", userRole=" + userRole
				+ ", country=" + country + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(userRole.name());
        return Collections.singletonList(authority);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
}
