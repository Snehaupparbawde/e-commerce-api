package org.dnyanyog.service;

import java.sql.SQLException;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;

public class AddUserService {

	public AddUserResponse addUser(AddUserRequest addUserBody) throws SQLException {

		AddUserResponse response = new AddUserResponse();
		

		if (addUserBody.addUserIntoDb()) {
			response.errorCode = "0000";
			response.message = "User Added Sucessfully!!!!";

			return response;
		}
		response.errorCode = "911";
		response.message = "User Added Failed!!!!";

		return response;
	}
}
