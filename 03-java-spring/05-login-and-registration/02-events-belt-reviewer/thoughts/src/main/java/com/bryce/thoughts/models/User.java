package com.bryce.thoughts.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

@Entity
@Table (name="users")
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private String password;
	@Transient
	private String confirmPw;
	@Column (updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Thought> messages;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "likes",
		joinColumns = @JoinColumn(name = "userId"),
		inverseJoinColumns = @JoinColumn(name = "thoughtId")
		)
	private List<Thought> thoughtsLiked;
	
	public User() {
	
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPw() {
		return confirmPw;
	}
	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Thought> getThoughts() {
		return messages;
	}
	public void setThoughts(List<Thought> thoughts) {
		this.messages = thoughts;
	}
	public List<Thought> getThoughtsLiked() {
		return thoughtsLiked;
	}
	public void setThoughtsLiked(List<Thought> thoughtsLiked) {
		this.thoughtsLiked = thoughtsLiked;
	}
	
	
	
	
	
}

