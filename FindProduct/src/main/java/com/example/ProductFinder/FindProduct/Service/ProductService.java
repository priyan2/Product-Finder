	package com.example.ProductFinder.FindProduct.Service;
	
	import java.util.List;
	
	import com.example.ProductFinder.FindProduct.Entity.Product;
	
	
	public interface ProductService {
		
	 	Product addProduct(Product product);
	    List<Product> getAllProducts();
	    List<Product> getAvailableProducts();
	    Product getProductBySkuId(int skuId);
	    List<Product> getProductsByName(String name);
	    boolean deleteProductById(int id);
	    Product getProductById(int id);
	    
//	    Product updateProduct(int id, Product updatedProduct);
	    Product save(Product product);
	
	    List<Product> filterByCategory(int categoryId);


	
	}
