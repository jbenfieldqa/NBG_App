package com.qac.nbg_app.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.nbg_app.services.IMSLoginService;
import com.qac.nbg_app.util.EmployeeCredentials;

@Named(value="imslogin")
@RequestScoped
public class IMSLoginController {
	@Inject
	private IMSLoginService loginService;
	@Inject
	EmployeeCredentials employeeCredentials;
	private String userName;
	private String password;
	private String error;
	
	public String login() {
		if (userName.equals("")){
			error = "Please enter username address";
			password = "";
			return "IMSLogin";
		}
		if (password.equals("")){
			error = "Please enter a password";
			password = "";
			return "IMSLogin";
		}
		if (!loginService.validateDetails(userName, password)) {
			error = "Invalid login";
			password = "";
			return "IMSLogin";
		}
		employeeCredentials.setEmployeeId(
				loginService.getUserID(userName));
		return "IMSOverview";
	}
	
	public String logout() {
		employeeCredentials.setEmployeeId(null);
		return "CatHome";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		if(userName != null)
			System.out.println("Name in system");
		else System.out.println("value doesn't exist");
		return true;
			
	}
	

}

