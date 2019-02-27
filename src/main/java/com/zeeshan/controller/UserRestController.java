package com.zeeshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zeeshan.model.User;
import com.zeeshan.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService service;

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody @Validated User user) {

		User user1 = service.createUser(user);
		if (user1 == null) {
			return ResponseEntity.badRequest().build();
		} else {
			return ResponseEntity.ok().build();
		}
	}

	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody @Validated User user) {

		User user1 = service.createUser(user);
		if (user1 == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {

		service.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/error")
	public ResponseEntity<Void> error() {
		return ResponseEntity.ok().build();
	}
}
