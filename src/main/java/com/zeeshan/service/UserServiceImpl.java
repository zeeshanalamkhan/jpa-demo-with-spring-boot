package com.zeeshan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeeshan.model.User;
import com.zeeshan.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAll() {

		return repository.findAll();
	}

	@Override
	public User getOne(Long id) {

		Optional<User> users = repository.findById(id);
		if (users.isPresent()) {
			return users.get();
		}
		return null;
	}

	@Override
	public User createUser(User user) {

		return repository.save(user);
	}

	@Override
	public boolean deleteUser(Long id) {

		repository.delete(repository.findById(id).get());
		return true;
	}

	@Override
	public User update(User user) {
		User user1 = repository.findById(user.getId()).get();
		if (user1 == null) {
			return null;
		}
		user1.setLastname(user.getLastname());
		return repository.save(user1);
	}

}
