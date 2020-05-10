package com.example.controlProducts.productManager.jdbc;

import com.example.controlProducts.productManager.Entity.Product;
import com.example.controlProducts.productManager.mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductJdbcTemplateRepository {
    JdbcTemplate jdbcTemplate;

    public List<Product> getAllProductByNameNameAndMadein(String name) {
        Object[] prams = new Object[]{name};
        ProductMapper mapper = new ProductMapper();
        /**
         * problem below
         */
        List<Product> products = jdbcTemplate.query("SELECT * FROM salesdb.product WHERE name = ? ;", prams, mapper);

        return products;
    }
}
