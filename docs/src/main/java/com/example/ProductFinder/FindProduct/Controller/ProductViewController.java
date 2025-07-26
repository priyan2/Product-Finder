//package com.example.ProductFinder.FindProduct.Controller;
//
//import com.example.ProductFinder.FindProduct.Entity.Category;
//import com.example.ProductFinder.FindProduct.Entity.Location;
//import com.example.ProductFinder.FindProduct.Entity.Product;
//import com.example.ProductFinder.FindProduct.Service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.*;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/product-ui")
//public class ProductViewController {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/list")
//    public String viewAllProducts(Model model) {
//        model.addAttribute("products", productService.getAllProducts());
//        return "product_list";
//    }
//
//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("product", new Product());
//        return "product_form";
//    }
//
////    @PostMapping("/save")
////    public String saveProduct(@ModelAttribute Product product,
////                              @RequestParam("imageFile") MultipartFile file) {
////
////        System.out.println("File received: " + file.getOriginalFilename());
////
////        if (!file.isEmpty()) {
////            try {
////                byte[] bytes = file.getBytes();
////                String fileName = file.getOriginalFilename();
////
////                Path path = Paths.get("src/main/resources/static/uploads/" + fileName);
////                Files.createDirectories(path.getParent());
////                Files.write(path, bytes);
////
////                product.setImageUrl("/uploads/" + fileName);
////
////            } catch (IOException e) {
////                System.out.println("Upload failed: " + e.getMessage());
////                e.printStackTrace();
////            }
////        }
////
////        productService.save(product);
////        return "redirect:/product-ui/list";
////    }
//    
//    
//   
//
//    @Controller
//    @RequestMapping("/product-ui")
//    public class ProductViewController {
//
//        @Autowired
//        private ProductService productService;
//
//        @GetMapping("/list")
//        public String viewAllProducts(Model model) {
//            model.addAttribute("products", productService.getAllProducts());
//            return "product_list";
//        }
//
//        @GetMapping("/add")
//        public String showAddForm(Model model) {
//            model.addAttribute("product", new Product());
//            return "product_form";
//        }
//
//        @PostMapping("/save")
//        public String saveProduct(@ModelAttribute Product product
//                                  /*, @RequestParam("imageFile") MultipartFile file*/) {
//
//            // Skipping file upload
//            // if (!file.isEmpty()) {
//            //     try {
//            //         byte[] bytes = file.getBytes();
//            //         String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//            //         Path uploadPath = Paths.get("uploads/" + fileName);
//            //         Files.createDirectories(uploadPath.getParent());
//            //         Files.write(uploadPath, bytes);
//            //         product.setImageUrl("/uploads/" + fileName);
//            //     } catch (IOException e) {
//            //         e.printStackTrace();
//            //     }
//            // }
//
//            productService.save(product);
//            return "redirect:/product-ui/list";
//        }
//
//        @GetMapping("/edit/{id}")
//        public String editProduct(@PathVariable int id, Model model) {
//            Product existing = productService.getProductById(id);
//            if (existing == null) {
//                return "redirect:/product-ui/list";
//            }
//
//            if (existing.getLocation() == null) {
//                existing.setLocation(new Location());
//            }
//
//            if (existing.getCategory() == null) {
//                Category cat = new Category();
//                cat.setId(1); // Default fallback
//                existing.setCategory(cat);
//            }
//
//            model.addAttribute("product", existing);
//            return "product_form";
//        }
//
////        @GetMapping("/delete/{id}")
////        public String deleteProduct(@PathVariable int id) {
////            productService.deleteProductById(id);
////            return "redirect:/product-ui/list";
////        }
//    
//
//
//    @GetMapping("/edit/{id}")
//    public String editProduct(@PathVariable int id, Model model) {
//    	
//
//        Product existing = productService.getProductById(id);
//        if (existing == null) {
//    	    return "redirect:/product-ui/list"; // or show an error page
//    	}
//        // Prevent null pointer by initializing empty nested objects if null
//        if (existing.getLocation() == null) {
//            existing.setLocation(new Location());
//        }
//        if (existing.getCategory() == null) {
//            Category cat = new Category();
//            cat.setId(1); // or default to some existing category ID
//            existing.setCategory(cat);
//        }
//        model.addAttribute("product", existing);
//        return "product_form";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable int id) {
//        productService.deleteProductById(id);
//        return "redirect:/product-ui/list";
//    }
//}

package com.example.ProductFinder.FindProduct.Controller;

import com.example.ProductFinder.FindProduct.Entity.Category;
import com.example.ProductFinder.FindProduct.Entity.Location;
import com.example.ProductFinder.FindProduct.Entity.Product;
import com.example.ProductFinder.FindProduct.Service.CategoryService;
import com.example.ProductFinder.FindProduct.Service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product-ui")
public class ProductViewController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String viewAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product_list";
    }

	/*
	 * @GetMapping("/add") public String showAddForm(Model model) {
	 * model.addAttribute("product", new Product()); return "product_form"; }
	 */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product_form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product
                              /*, @RequestParam("imageFile") MultipartFile file*/) {

        // Skipping file upload
        // if (!file.isEmpty()) {
        //     try {
        //         byte[] bytes = file.getBytes();
        //         String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        //         Path uploadPath = Paths.get("uploads/" + fileName);
        //         Files.createDirectories(uploadPath.getParent());
        //         Files.write(uploadPath, bytes);
        //         product.setImageUrl("/uploads/" + fileName);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }

        productService.save(product);
        return "redirect:/product-ui/list";
    }

//    @GetMapping("/edit/{id}")
//    public String editProduct(@PathVariable int id, Model model) {
//        Product existing = productService.getProductById(id);
//        if (existing == null) {
//            return "redirect:/product-ui/list";
//        }
//
//        if (existing.getLocation() == null) {
//            existing.setLocation(new Location());
//        }
//
//        if (existing.getCategory() == null) {
//            Category cat = new Category();
//            cat.setId(1); // Default fallback
//            existing.setCategory(cat);
//        }
//
//        model.addAttribute("product", existing);
//        return "product_form";
//    }
    
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Product existing = productService.getProductById(id);
        if (existing == null) {
            return "redirect:/product-ui/list";
        }

        if (existing.getLocation() == null) {
            existing.setLocation(new Location());
        }
        if (existing.getCategory() == null) {
            Category cat = new Category();
            cat.setId(1); // fallback default
            existing.setCategory(cat);
        }

        model.addAttribute("product", existing);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "product_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/product-ui/list";
    }

	/* Product view only controller code starts here*/
    
    
//    
//    @GetMapping("/products/view-only")
//    public String viewOnlyProducts(Model model) {
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "productView";
//    }
    
    @GetMapping("/products/view-only")
    public String viewOnlyProducts(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Integer categoryId,
            Model model
    ) {
        List<Product> products;

        if (search != null && !search.isEmpty()) {
            products = productService.getProductsByName(search);
        } else if (categoryId != null && categoryId != 0) {
            products = productService.filterByCategory(categoryId);
        } else {
            products = productService.getAllProducts(); // For null or categoryId == 0
        }

        model.addAttribute("products", products);
        model.addAttribute("search", search);
        model.addAttribute("selectedCategoryId", categoryId != null ? categoryId : 0); // fallback to 0
        model.addAttribute("categories", categoryService.getAllCategories());

        return "productView";
    }
}
