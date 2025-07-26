package com.example.ProductFinder.FindProduct.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductFinder.FindProduct.Entity.Product;
import com.example.ProductFinder.FindProduct.Repository.ProductRepository;
import com.example.ProductFinder.FindProduct.Service.ProductService;

@Service
public class ProductImpl implements ProductService {
	 @Autowired
	    private ProductRepository productRepository;

	    @Override
	    public Product addProduct(Product product) {
	        return productRepository.save(product);
	    }

	    @Override
	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }
	    
	    @Override
	    public List<Product> getAvailableProducts() {
	        return productRepository.findByAvailableTrue();
	    }

	    @Override
	    public Product getProductBySkuId(int skuId) {
	        return productRepository.findBySkuId(skuId);
	    }

	    @Override
	    public List<Product> getProductsByName(String name) {
	        return productRepository.findByNameIgnoreCase(name);
	    }
	    
	    public boolean deleteProductById(int id) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        if (optionalProduct.isPresent()) {
	            productRepository.delete(optionalProduct.get());
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    @Override
	    public Product getProductById(int id) {
	        return productRepository.findById(id).orElse(null);
	    }
	    
	    public Product save(Product product) {
	        if (product.getId() != 0) {
	            Product existing = productRepository.findById(product.getId()).orElse(null);
	            if (existing != null) {
	                // Update fields manually if needed
	                existing.setName(product.getName());
	                existing.setPrice(product.getPrice());
	                existing.setBrand(product.getBrand());
	                existing.setCategory(product.getCategory());
	                existing.setLocation(product.getLocation());
	                existing.setAvailable(product.isAvailable());
	                existing.setDescription(product.getDescription());
	                existing.setImageUrl(product.getImageUrl());
	                return productRepository.save(existing);
	            }
	        }

	        return productRepository.save(product); // for new entries
	    }

//	    
////	    @Override
////	    public Product save(Product product) {
////	        return productRepository.save(product); 
////	    }
	    @Override
	    public List<Product> filterByCategory(int categoryId) {
	        return productRepository.findByCategoryId(categoryId);
	    }

//		@Override
//		public Product updateProduct(int id, Product updatedProduct) {
//			// TODO Auto-generated method stub
//			return null;
//		}
	    
	    
	    



}
