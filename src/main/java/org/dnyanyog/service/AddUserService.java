package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;

public class AddUserService {

	public AddUserResponse addUser(AddUserRequest addUserBody) throws SQLException {

		AddUserResponse response = new AddUserResponse();
		String query = "INSERT INTO add_user(name,email,gender,address,username,password) VALUES " + "('"
				+ addUserBody.name + "','" + addUserBody.email + "','" + addUserBody.gender + "','"
				+ addUserBody.address + "','" + addUserBody.username + "','" + addUserBody.password + "') ";
		Dbutils.executeQuery(query);
		String selectQuery = "select * from add_user where name='" + addUserBody.name + "'";
		ResultSet resultset = Dbutils.executeSelectQuery(selectQuery);

		if (resultset.next()) {
			response.errorCode = "0000";
			response.message = "User Added Sucessfully!!!!";

			return response;
		}
		response.errorCode = "911";
		response.message = "User Added Failed!!!!";

		return response;
	}
}
