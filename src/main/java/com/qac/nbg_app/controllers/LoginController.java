package com.qac.nbg_app.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.services.LoginService;
import com.qac.nbg_app.util.UserCredentials;

@Named(value="login")
@SessionScoped
public class LoginController implements Serializable {
	@Inject
	private LoginService loginService;
	@Inject
	UserCredentials userCredentials;
	private String email;
	private String password;
	private String error;
	private boolean loggedIn = false;
	
	public String login() {
		if (email.equals("")){
			error = "Please enter an email address";
			password = "";
			return "CatLogin";
		}
		if (password.equals("")){
			error = "Please enter a password";
			password = "";
			return "CatLogin";
		}
		if (!loginService.validateDetails(email, password)) {
			error = "Invalid login";
			password = "";
			return "CatLogin";
		}
		userCredentials.setEmail(loginService.getUserID(email));
		setLoggedIn(true);
		return "CatHome";
	}
	
	public String logout() {
		userCredentials.setEmail(null);
		setLoggedIn(false);
		return "CatHome";
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

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	

}
