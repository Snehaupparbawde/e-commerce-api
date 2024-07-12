package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.dto.Login;

public class LoginService {
	public String login(Login loginBody) throws SQLException {
		String loginquery = "SELECT * FROM login WHERE user='" + loginBody.user + "' AND password = '"
				+ loginBody.password + "'";
		ResultSet resultset = Dbutils.executeSelectQuery(loginquery);
		if (resultset.next()) {
			return "Login Success";

		}
		return "Login Failed";

	}

}
