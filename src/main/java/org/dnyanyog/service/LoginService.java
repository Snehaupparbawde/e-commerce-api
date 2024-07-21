package org.dnyanyog.service;

import org.dnyanyog.dao.UsersDao;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

	@Autowired
	private UsersDao userDao;

	public LoginResponse login(LoginRequest loginBody) {
		LoginResponse response = new LoginResponse();

		Users user = userDao.findByLoginName(loginBody.user);
		Users userReceivedFromDB = userDao.findByLoginName(loginBody.user);

		if (userReceivedFromDB.getLoginName().equals(loginBody.user)
				&& userReceivedFromDB.getPassword().equals(loginBody.password)) {

			response.errorCode = "0000";
			response.message = "Login Success";
			response.id = user.getUser_id();
			response.firstName = user.getFirstName();
			response.lastName = user.getLastName();
			response.loginName = user.getLoginName();
			return response;

		}

		response.errorCode = "911";
		response.message = "Login Failed";

		return response;
	}
}
