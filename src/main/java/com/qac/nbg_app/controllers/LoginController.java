package com.qac.nbg_app.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.services.LoginService;
import com.qac.nbg_app.util.UserCredentials;

@Named(value="login")
@RequestScoped
public class LoginController {
	@Inject
	private LoginService loginService;
	@Inject
	UserCredentials userCredentials;
	private String email;
	private String password;
	private String error;
	
	public String login() {
		if (email.equals("")){
			error = "please enter an email address";
			password = "";
			return "login";
		}
		if (password.equals("")){
			error = "please enter a password";
			password = "";
			return "login";
		}
		if (!loginService.validateDetails(email, password)) {
			error = "Invalid login";
			password = "";
			return "login";
		}
		userCredentials.setEmail(
				loginService.getUserID(email));
		return "browse";
	}
	
	public String logout() {
		userCredentials.setEmail("");
		return "home";
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

	public void setPassword(String pass) {
		this.password = pass;
	}

	public String getError() {
		return error;
	}
	public boolean checkName()
	{
		if(email != null)
			System.out.println("Name in system");
		else System.out.println("value doesn't exist");
		return true;
			
	}
	

}
