package com.bryce.dojoOverflow.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tag {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String subject;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="questions_tags",
		joinColumns= @JoinColumn(name="tagId"),
		inverseJoinColumns = @JoinColumn(name="questionId")
		)
	private List<Question> tquests;

	public Tag() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Question> getTquests() {
		return tquests;
	}

	public void setTquests(List<Question> tquests) {
		this.tquests = tquests;
	}
	
	
	
}
