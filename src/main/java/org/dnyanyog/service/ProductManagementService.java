package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.Dbutils;
import org.dnyanyog.dto.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductManagementService {
	public List<Product> getAllProduct() throws SQLException {

		ArrayList<Product> productList = new ArrayList<>();

		String query = "SELECT * from product ";
		ResultSet resultset = Dbutils.executeSelectQuery(query);

		while (resultset.next()) {

			Product product = new Product();
			product.productname = resultset.getString("product_name");
			product.productquantity = resultset.getString("product_quantity");
			product.productprice = resultset.getString("product_price");

			productList.add(product);
		}
		return productList;
	}

}
