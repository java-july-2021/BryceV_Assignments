package com.bryce.productsCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryce.productsCategories.models.Category;
import com.bryce.productsCategories.models.Product;
import com.bryce.productsCategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public Product getSingleProd(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public List<Product> findProdNotCat(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}
	public void addCatToProduct(Product product, Category category) {
		List<Category> existingCategory = product.getCategories();
		existingCategory.add(category);
		this.pRepo.save(product);
	}
}
