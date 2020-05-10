package com.example.controlProducts.productManager.mapper;

import com.example.controlProducts.productManager.Entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String brand = rs.getString("brand");
        String madein = rs.getString("madein");
        Float price = rs.getFloat("price");

        Product product = new Product();

        product.setId(id);
        product.setName(name);
        product.setBrand(brand);
        product.setMadein(madein);
        product.setPrice(price);

        return product;
    }
}
