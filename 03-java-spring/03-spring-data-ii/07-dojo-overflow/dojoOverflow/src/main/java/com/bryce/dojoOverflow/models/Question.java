package com.bryce.dojoOverflow.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String questionText;
	@Transient
	private String tagsFromForm;
	
	@OneToMany(mappedBy="quest", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Answer> answers;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="questions_tags",
		joinColumns= @JoinColumn(name="questionId"),
		inverseJoinColumns = @JoinColumn(name="tagId")
		)
	private List<Tag> qtags;

	public Question() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getTagsFromForm() {
		return tagsFromForm;
	}

	public void setTagsFromForm(String tagsFromForm) {
		this.tagsFromForm = tagsFromForm;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getQtags() {
		return qtags;
	}

	public void setQtags(List<Tag> qtags) {
		this.qtags = qtags;
	}
	
	
	
}
