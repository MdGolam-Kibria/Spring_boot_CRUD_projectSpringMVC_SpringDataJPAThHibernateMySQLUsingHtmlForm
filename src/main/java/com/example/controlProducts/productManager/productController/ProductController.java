package com.example.controlProducts.productManager.productController;

import com.example.controlProducts.productManager.Entity.Product;
import com.example.controlProducts.productManager.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")//update a product using Product id
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    //@RequestMapping(value = "/save", method = RequestMethod.POST)//This Method for Button Control
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "newProduct";
        } else {
            productService.save(product);
            return "redirect:/";
        }
    }

    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, Errors errors) {
        if (errors.hasErrors()) {
            return "editProduct";
        } else {
            productService.save(product);
            return "redirect:/";
        }
    }
}

@RestController
class ForRestService {
    @Autowired
    public ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.listAll();
    }

    @GetMapping("/getAllProductByHerBrandName/{brand}")
    //This controller using @Query annotation
    List<Product> getAllProductByHerBrand(@PathVariable(name = "brand") String brand) {
        return productService.getAllProductByBrand(brand);
    }

    @GetMapping("/getAllProductByHerBrandNameAndMadeIn/{brand}/{madein}")
    //This controller using @Query annotation
    List<Product> getAllProductByBrandAndMadein(@PathVariable(name = "brand") String brand, @PathVariable(name = "madein") String madein) {
        return productService.getAllProductByBrandAndMadein(brand, madein);
    }

    /**
     * below method here i use ###Put and get together because this methos logic is at first put some data then the method return
     * something means ###Get that's the reason i use Put And Get mapping together.
     */
    //This controller using @Query annotation
    @RequestMapping(value = "/updateProductBrandByIdAndBrandName/{id}/{brand}", method = {RequestMethod.PUT, RequestMethod.GET})
    String updateProductBrandByIdAndBrandName(@PathVariable(name = "id") String id, @PathVariable(name = "brand") String brand) {
        productService.updateProductBrandByIdAndBrandName(Long.parseLong(id), brand);//jehoto parametar ta string tai string to Long e covert kora hoise
        return "update the brand name";
    }
}