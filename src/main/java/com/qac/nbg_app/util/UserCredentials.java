package com.qac.nbg_app.util;

import java.io.Serializable;

public class UserCredentials implements Serializable {
	
	private String email;
	
	protected String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
