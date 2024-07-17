package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.dto.AddProductRequest;
import org.dnyanyog.dto.AddProductResponse;

public class AddProductService {
	public AddProductResponse addProduct(AddProductRequest addProductBody) throws SQLException {

		AddProductResponse response = new AddProductResponse();

		String query = "INSERT INTO add_product(product_name,product_quantity,product_price) VALUES " + "('"
				+ addProductBody.productname + "','" + addProductBody.productquantity + "','"
				+ addProductBody.productprice + "') ";
		Dbutils.executeQuery(query);
		String selectQuery = "select * from add_product where product_name='" + addProductBody.productname + "'";
		ResultSet resultset = Dbutils.executeSelectQuery(selectQuery);

		if (resultset.next()) {
			response.errorCode = "0000";
			response.message = "Product Added Sucessfully!!!!";

			return response;
		}
		response.errorCode = "911";
		response.message = "Product Added Failed!!!!";

		return response;
	}

}
