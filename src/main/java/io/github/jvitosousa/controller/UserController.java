package io.github.jvitosousa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.jvitosousa.controller.dto.UserDTO;
import io.github.jvitosousa.domain.entity.Propriedade;
import io.github.jvitosousa.domain.entity.User;
import io.github.jvitosousa.exception.RegraDeNegocioException;
import io.github.jvitosousa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
    
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO body) throws Exception {
		try {
			User response = userService.createUser(body.toEtity());
			return new ResponseEntity<User>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		try {
			List<User> response = userService.getUsers();
			return new ResponseEntity<List<User>>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable Integer id) {
		try {
			Optional<User> response = userService.getUser(id);
			if(response.isEmpty()) {
				return new ResponseEntity<Optional<User>>(response, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Optional<User>>(response, HttpStatus.OK);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody UserDTO body) throws Exception {
		try {
			User response = userService.createUser(body.toEtity());
			return new ResponseEntity<User>(response, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RegraDeNegocioException(e.getMessage());
		}
	}
	
}
