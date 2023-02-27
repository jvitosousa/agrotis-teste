package io.github.jvitosousa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.entity.User;
import io.github.jvitosousa.domain.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		try {
			User result = userRepository.save(user);
			return result;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<User> getUsers() {
		List<User> result = userRepository.findAll();
		return result;
	}

	public Optional<User> getUser(Integer id) {
		Optional<User> result = userRepository.findById(id);
		return result;
	}

	public void deleteUser(Integer id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			throw e;
		}
	}
	

}
