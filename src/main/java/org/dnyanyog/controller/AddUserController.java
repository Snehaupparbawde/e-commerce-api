package org.dnyanyog.controller;

import java.sql.SQLException;

import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.service.AddUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserController {

	@PostMapping("/addUser")
	public AddUserResponse addUser(@RequestBody AddUserRequest addUserBody) throws SQLException {

		return new AddUserService().addUser(addUserBody);

	}

}
