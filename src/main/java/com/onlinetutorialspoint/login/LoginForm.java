package com.onlinetutorialspoint.login;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class LoginForm {
	@NotNull
	@Size(min = 2, max = 30)
	@Id
	private String userName;

	@NotNull
	//@Min(5)
	private String password;

	public String getuserName() {
		return this.userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "LoginForm(UserName: " + this.userName + ", Password: " + this.password + ")";
	}
}
