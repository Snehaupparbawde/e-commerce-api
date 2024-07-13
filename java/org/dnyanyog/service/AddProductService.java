package org.dnyanyog.service;

import java.sql.SQLException;

import org.dnyanyog.dto.AddProductRequest;
import org.dnyanyog.dto.AddProductResponse;

public class AddProductService {
	public AddProductResponse addProduct(AddProductRequest addProductBody) throws SQLException {

		AddProductResponse response = new AddProductResponse();

		if (addProductBody.addProductIntoDb()) {
			response.errorCode = "0000";
			response.message = "Product Added Sucessfully!!!!";

			return response;
		}
		response.errorCode = "911";
		response.message = "Product Added Failed!!!!";

		return response;
	}

}
