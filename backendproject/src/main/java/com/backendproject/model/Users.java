package com.backendproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name="BF_users")
@Component
public class Users { // it will not map this user class with table user
	@Id
private String username;
	@NotNull(message=" name is mandatory")	
private String firstname;
	@NotNull(message=" name is mandatory")
private String lastname;

@Column(name="EMAIL", length=50)
@NotNull
@Size(min=7,max=50)
@Pattern(regexp="^.+@.+\\..+$")
private String email;

@Size(min=7,max=10)
private String password;
private String role;
private boolean enabled;
@Column(name="on_line") private boolean online;


public boolean isOnline() {
	return online;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}


public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public void setOnline(boolean b){
}
}


