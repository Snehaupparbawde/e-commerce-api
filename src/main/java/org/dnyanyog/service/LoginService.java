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
	UsersDao userDao;

	public LoginResponse login(LoginRequest loginBody) {
		LoginResponse response = new LoginResponse();

		Users user = userDao.findByLoginName(loginBody.user);
		if (user.getLoginName().equals(loginBody.user) && user.getPassword().equals(loginBody.password)) 
		{

			response.errorCode = "0000";
			response.message = "Login Success";
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
