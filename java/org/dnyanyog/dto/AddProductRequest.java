package org.dnyanyog.dto;

import java.sql.SQLException;

import org.dnyanyog.common.Dbutils;

public class AddProductRequest {
	public String productname;
	public String productquantity;
	public String productprice;

	public AddProductRequest(String productname, String productquantity, String productprice) {
		this.productname = productname;
		this.productquantity = productquantity;
		this.productprice = productprice;
	}

	public boolean addProductIntoDb() throws SQLException {

		String query = "INSERT INTO add_product(product_name,product_quantity,product_price) VALUES " + "('"
				+ productname + "','" + productquantity + "','" + productprice + "') ";

		int rowsInserted = Dbutils.executeUpdateQuery(query);
		return rowsInserted > 0;

	}
}