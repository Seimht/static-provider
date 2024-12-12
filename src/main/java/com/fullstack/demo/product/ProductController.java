package com.fullstack.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("productList", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-detail";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    @GetMapping("/new")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());  // Add an empty Product object
        return "product-create";  // Return the form view
    }

    @PostMapping("/new")
    public String addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/api/products/all";
    }

    @PostMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") int productId, @ModelAttribute Product product, Model model) {
        product.setProductId(productId);
        productService.updateProduct(productId, product);
        return "redirect:/api/products/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/api/products/all";
    }
}
