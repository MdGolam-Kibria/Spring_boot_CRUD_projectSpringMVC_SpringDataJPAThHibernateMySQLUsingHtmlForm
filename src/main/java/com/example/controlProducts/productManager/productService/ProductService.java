package com.example.controlProducts.productManager.productService;

import com.example.controlProducts.productManager.Entity.Product;
import com.example.controlProducts.productManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
