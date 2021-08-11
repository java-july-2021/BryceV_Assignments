package com.bryce.productsCategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryce.productsCategories.models.Category;
import com.bryce.productsCategories.models.Product;
import com.bryce.productsCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public Category getSingleCat(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	public List<Category> findCatNotProd(Product product) {
		return this.cRepo.findByProductsNotContains(product);
	}
	public void addProductToCat(Product product, Category category) {
		List<Product> existingProducts = category.getProducts();
		existingProducts.add(product);
		this.cRepo.save(category);
	}
}
