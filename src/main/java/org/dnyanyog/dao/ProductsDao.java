package org.dnyanyog.dao;

import org.dnyanyog.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsDao extends JpaRepository<Products, Integer> {
	public Products findByProductName(String productName);
}
