package com.bryce.thoughts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bryce.thoughts.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	List<User> findAll();
	boolean existsByEmail(String email);
}
