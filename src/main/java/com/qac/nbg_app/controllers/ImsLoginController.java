package com.qac.nbg_app.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "login")
@RequestScoped

//classes 
public class ImsLoginController {
	@Inject
	LoginService loginService;
	@Inject
	UserCredentials userCredentials;
	private String username = "";
	private String password = "";
	private String error = "";
	
	public String login(){
		if (username.equals("")){
			error = "please enter a username";
			password = "";
			return "login";
		}
		if (password.equals("")){
			error = "please enter a password";
			password = "";
			return "login";
		}
		if (!customerService.validateDetails(username,password)){
			error = "Invalid login";
			password = "";
			return "login";
		}
		userCredentials.setUsers(loginService.getUserID(username));
		return "home";
		
	}
	public String logout(){
		userCredentials.setUser("");
		return "home";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	

}
