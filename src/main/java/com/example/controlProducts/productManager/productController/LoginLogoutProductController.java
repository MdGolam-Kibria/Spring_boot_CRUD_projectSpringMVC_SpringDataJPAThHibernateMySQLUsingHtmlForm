package com.example.controlProducts.productManager.productController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginLogoutProductController {
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @PostMapping("/after_successfully_login_page")
    public String afterLoginPage(){
        return "editProduct";
    }
}
