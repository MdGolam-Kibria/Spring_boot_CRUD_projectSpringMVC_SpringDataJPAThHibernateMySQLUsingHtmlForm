package com.example.controlProducts.productManager.productService;

import com.example.controlProducts.productManager.Entity.Product;
import com.example.controlProducts.productManager.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
   public List<Product> getAllProductByNameOrBrand(String nameOrBrand){//for search
        if (nameOrBrand!=null) {
            return productRepository.getAllProductByNameOrBrand(nameOrBrand);
        }else {
            return productRepository.findAll();
        }
    }
    /**
     *below this is another good searching query.
     *For searching with any data of the table here like id,name,brand,madein,price even any word or number.
     */
   public List<Product> getAllProductByIdNameBrandMadeinPrice(String idNameBrandMadeinPrice){
        if (idNameBrandMadeinPrice!=null){
            return productRepository.getAllProductByIdNameBrandMadeinPrice(idNameBrandMadeinPrice);
        }else {
            return productRepository.findAll();
        }
   }

    public List<Product> getAllProductByBrand(String brand) {
        return productRepository.getAllProductByBrand(brand);
    }

    public List<Product> getAllProductByBrandAndMadein(String brand, String madein) {
        return productRepository.getAllProductByBrandAndMadein(brand, madein);
    }

    public void updateProductBrandByIdAndBrandName(Long id, String brand) {
        productRepository.updateProductBrandByIdAndBrandName(id, brand);
    }
}
