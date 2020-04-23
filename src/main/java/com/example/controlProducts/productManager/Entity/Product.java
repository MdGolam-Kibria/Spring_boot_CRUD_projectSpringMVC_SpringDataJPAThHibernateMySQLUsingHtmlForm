package com.example.controlProducts.productManager.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Product {
    private Long id;
    @NotNull
    @NotEmpty(message = "Name field should not be empty")
    @NotBlank
    @Size(min = 2, max = 20, message = "length shoud be in between 2 to 10")
    private String name;
    @NotNull
    @Size(min = 2, max = 20, message = "length shoud be in between 2 to 10")
    @NotEmpty(message = "Brand field should not be empty")
    @NotBlank
    private String brand;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Made in field should not be empty")
    @Size(min = 2, max = 20, message = "length shoud be in between 2 to 10")
    private String madein;
    @DecimalMin("1.00")
    private float price;

    public Product() {
    }

    public Product(Long id, String name, String brand, String madein, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.madein = madein;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", madein='" + madein + '\'' +
                ", price=" + price +
                '}';
    }
}
