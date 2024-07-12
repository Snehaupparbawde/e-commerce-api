package org.dnyanyog.dto;

import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;

public class AddUserRequest {
	public String name;
	public String email;
	public String gender;
	public String address;
	public String username;
	public String password;

	public AddUserRequest(String name, String email, String gender, String address, String username, String password) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public boolean addUserIntoDb() throws SQLException {

		String query = "INSERT INTO add_user(name,email,gender,address,username,password) VALUES " + "('" + name + "','"
				+ email + "','" + gender + "','" + address + "','" + username + "','" + password + "') ";

		int rowsInserted = Dbutils.executeUpdateQuery(query);
		return rowsInserted > 0;

	}

}
