package com.example.controlProducts.productManager.springSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEn {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String rowPasswordUser = "413152";
        String rowPasswordAdmin = "abboammo@gmail.com.bd";
        String encodedPassword = encoder.encode(rowPasswordUser);
        System.out.println(encodedPassword);
    }
}
