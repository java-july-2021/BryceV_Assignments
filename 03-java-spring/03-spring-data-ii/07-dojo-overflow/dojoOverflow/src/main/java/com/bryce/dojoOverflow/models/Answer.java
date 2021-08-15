package com.bryce.dojoOverflow.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String answerBody;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="questionId")
	private Question quest;

	public Answer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswerBody() {
		return answerBody;
	}

	public void setAnswerBody(String answerBody) {
		this.answerBody = answerBody;
	}

	public Question getQuest() {
		return quest;
	}

	public void setQuest(Question quest) {
		this.quest = quest;
	}
	
	
}
