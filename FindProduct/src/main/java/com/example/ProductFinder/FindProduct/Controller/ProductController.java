package com.example.ProductFinder.FindProduct.Controller;

import com.example.ProductFinder.FindProduct.Entity.Product;
import com.example.ProductFinder.FindProduct.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/available")
    public List<Product> getAvailableProducts() {
        return productService.getAvailableProducts();
    }

    @GetMapping("/sku/{skuId}")
    public Product getProductBySkuId(@PathVariable int skuId) {
        return productService.getProductBySkuId(skuId);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        boolean isDeleted = productService.deleteProductById(id);
        return isDeleted ? "Product deleted successfully." : "Product not found.";
    }
     
}
