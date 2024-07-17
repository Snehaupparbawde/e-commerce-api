package org.dnyanyog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagementController {
	
	@Autowired
	ProductManagementService productManagementService;

	@GetMapping("/getAllProduct")
	public List<org.dnyanyog.dto.Product> getAllUser() throws SQLException {
		return productManagementService.getAllProduct();
	}

}
