package com.example.ProductFinder.FindProduct.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ProductFinder.FindProduct.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findByAvailableTrue();
    Product findBySkuId(int skuId);
    List<Product> findByNameIgnoreCase(String name);
    List<Product> findByCategory_CategoryName(String categoryName);
    List<Product> findByCategoryId(int categoryId);
    
    List<Product> findByNameContainingIgnoreCase(String name);
    

}
