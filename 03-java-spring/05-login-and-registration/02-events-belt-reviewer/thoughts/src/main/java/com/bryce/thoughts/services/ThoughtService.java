package com.bryce.thoughts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryce.thoughts.models.Thought;
import com.bryce.thoughts.models.User;
import com.bryce.thoughts.repositories.ThoughtRepository;



@Service
public class ThoughtService {
	@Autowired
	private ThoughtRepository tRepo;
	
	public Thought createThought(Thought message) {
		return this.tRepo.save(message);
	}
	public Thought getSingleThought(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	public List<Thought> allThoughts() {
		return this.tRepo.findAll();
	}
	public void likeThought(Thought message, User userToLike) {
		List<User> usersLiking = message.getLikers();
		usersLiking.add(userToLike);
		this.tRepo.save(message);
		
	}
	public void unLikeThought(Thought message, User userToLike) {
		List<User> usersLiking = message.getLikers();
		usersLiking.remove(userToLike);
		this.tRepo.save(message);
	}
	public Thought update(Thought thought) {
		return this.tRepo.save(thought);
	}
	public void deleteThought(Thought thought) {
		this.tRepo.delete(thought);
	}
	
}
