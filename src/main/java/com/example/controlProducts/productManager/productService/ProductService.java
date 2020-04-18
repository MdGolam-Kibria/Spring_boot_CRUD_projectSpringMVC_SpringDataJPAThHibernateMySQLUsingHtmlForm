package com.example.controlProducts.productManager.productService;

import com.example.controlProducts.productManager.Entity.Product;
import com.example.controlProducts.productManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll(){
        return productRepository.findAll();
    }
    public List<Product> save(Product product){
        List<Product>  products = (List<Product>) productRepository.save(product);
        return products;
    }
    public Product get(Long id){
        return productRepository.findById(id).get();
    }
    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
