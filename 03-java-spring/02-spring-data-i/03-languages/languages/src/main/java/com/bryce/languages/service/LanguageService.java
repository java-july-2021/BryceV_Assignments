package com.bryce.languages.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bryce.languages.models.Language;
import com.bryce.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository repo) {
		langRepo = repo;
	}
	
	//FIND ALL LANGUAGES
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	
	//FIND ONE LANGUAGE
	public Language findLanguage(Long id) {
		return langRepo.findById(id).orElse(null);
	}
	
	//CREATE LANGUAGE
	public Language createLanguage(Language newLanguage) {
		return langRepo.save(newLanguage);
	}
	
	//UPDATE LANGUAGE
	public Language updateLanguage(Language updatedLanguage) {
		return langRepo.save(updatedLanguage);
	}
	
	//DELETE LANGUAGE
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
