package com.qac.nbg_app.util;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class UserCredentials implements Serializable {	
	private String email;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
