package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;

public class LoginService {
	public LoginResponse login(LoginRequest loginBody) throws SQLException {
		LoginResponse response = new LoginResponse();
		String loginquery = "SELECT * FROM login WHERE user='" + loginBody.user + "' AND password = '"
				+ loginBody.password + "'";
		ResultSet resultset = Dbutils.executeSelectQuery(loginquery);
		if (resultset.next()) {

			response.errorCode = "0000";
			response.message = "Login Success";
			return response;
		}
		response.errorCode = "911";
		response.message = "Login Failed";
		return response;
	}

}
