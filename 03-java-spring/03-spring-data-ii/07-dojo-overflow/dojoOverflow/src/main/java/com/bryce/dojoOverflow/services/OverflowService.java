package com.bryce.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryce.dojoOverflow.models.Answer;
import com.bryce.dojoOverflow.models.Question;
import com.bryce.dojoOverflow.models.Tag;
import com.bryce.dojoOverflow.repositories.AnswerRepository;
import com.bryce.dojoOverflow.repositories.QuestionRepository;
import com.bryce.dojoOverflow.repositories.TagRepository;

@Service
public class OverflowService {
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private TagRepository tRepo;
	
	public Tag getOneTag(String subject) {
		return this.tRepo.findBySubject(subject);
	}
	
	public ArrayList<Tag> sepTags(String tags) {
		ArrayList<Tag> tagsForQuestion = new ArrayList<Tag>();
		String[] tagsToProcess = tags.split(", ");
		for(String s : tagsToProcess) {
			if(this.tRepo.existsBySubject(s)) {
				Tag tagToAdd = this.getOneTag(s);
				tagsForQuestion.add(tagToAdd);
			}
			else {
				Tag newTag = new Tag();
				newTag.setSubject(s);
				this.tRepo.save(newTag);
				tagsForQuestion.add(this.getOneTag(s));
			}
		}
		return tagsForQuestion;
	}
	
	public Question createQuestion(Question question) {
		question.setQtags(this.sepTags(question.getTagsFromForm()));
		return this.qRepo.save(question);
	}
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	public List<Question> getAllQuestions() {
		return this.qRepo.findAll();
	}
	
	public Question findOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
}
