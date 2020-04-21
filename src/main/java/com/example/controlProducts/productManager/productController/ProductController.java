package com.example.controlProducts.productManager.productController;

import com.example.controlProducts.productManager.Entity.Product;
import com.example.controlProducts.productManager.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    public ProductService productService;

    @RequestMapping("/")//This is home page
    public String viewHomePage(Model model) {//this model parameter from spring MVC
        List<Product> productsList = productService.listAll();
        model.addAttribute("listProducts", productsList);
        return "index";
    }

    @RequestMapping("/addNewProduct")//add a new product on home page
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "newProduct";
    }
    @RequestMapping("/edit/{id}")//update a product using Product id
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
       ModelAndView modelAndView = new ModelAndView("editProduct");
       Product product = productService.get(id);
       modelAndView.addObject("product",product);
       return modelAndView;
    }

    @RequestMapping("/delete/{id}")//update a product using Product id
    public String deleteProduct(@PathVariable(name = "id") Long id) {
       productService.deleteById(id);
       return "redirect:/";
    }
     @RequestMapping(value = "/save", method = RequestMethod.POST)//This Method for Button Control
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }

}
