package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserManagementService {

	public List<User> getAllUser() throws SQLException {

		ArrayList<User> userList = new ArrayList<>();

		String query = "SELECT * from user ";
		ResultSet resultset = Dbutils.executeSelectQuery(query);

		while (resultset.next()) {

			User user = new User();
			user.firstName = resultset.getString("firstName");
			user.lastName = resultset.getString("lastNameame");
			user.gender = resultset.getString("gender");
			user.email = resultset.getString("email");
			user.address = resultset.getString("address");
			user.password = resultset.getString("password");

			userList.add(user);
		}
		return userList;
	}

}
