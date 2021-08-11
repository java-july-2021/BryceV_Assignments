package com.bryce.productsCategories.controllers;



import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bryce.productsCategories.models.Category;
import com.bryce.productsCategories.models.Product;
import com.bryce.productsCategories.services.CategoryService;
import com.bryce.productsCategories.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService cService;
	@Autowired
	private ProductService pService;
	
	@GetMapping("/products/new")
	public String newProd() {
		return "newProduct.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCat() {
		return "newCategory.jsp";
	}
	
	@PostMapping("/newCat")
	public String createCat(@RequestParam("cat") String category) {
		Category newCat = new Category();
		newCat.setName(category);
		this.cService.createCategory(newCat);
		return "showCat.jsp";
	}
	@PostMapping("/newProd")
	public String createProd(@RequestParam("product") String name, @RequestParam("description") String description, @RequestParam("price") Double price) {
		Product newProd = new Product(name, description, price);
		this.pService.createProduct(newProd);
		return "showProd.jsp";
	}
	@GetMapping("/products/{id}")
	public String showProd(Model viewModel, @PathVariable("id") Long id) {
		Product productToShow = this.pService.getSingleProd(id);
		viewModel.addAttribute("notInProd", this.cService.findCatNotProd(productToShow));
		viewModel.addAttribute("product", productToShow);
		return "showProd.jsp";
		}
	@PostMapping("/addCatToProd/{id}")
	public String addCatToProd(@RequestParam("cats") Long id, @PathVariable("id") Long product_id) {
		Product productToAdd = this.pService.getSingleProd(product_id);
		Category categoryToAdd = this.cService.getSingleCat(id);
		this.pService.addCatToProduct(productToAdd, categoryToAdd);
		return "redirect:/products/{id}";
	}
	@GetMapping("/categories/{id}")
	public String showCat(Model viewModel, @PathVariable("id") Long id) {
		Category categoryToShow = this.cService.getSingleCat(id);
		viewModel.addAttribute("notInCat", this.pService.findProdNotCat(categoryToShow));
		viewModel.addAttribute("category", categoryToShow);
		return "showCat.jsp";	
	}
	@PostMapping("/prodToCat/{id}")
	public String addProdToCat(@RequestParam("prod") Long id, @PathVariable("id") Long category_id) {
		Product productToAdd = this.pService.getSingleProd(id);
		Category categoryToAdd = this.cService.getSingleCat(category_id);
		this.cService.addProductToCat(productToAdd, categoryToAdd);
		return "redirect:/categories/{id}";
	}
}
