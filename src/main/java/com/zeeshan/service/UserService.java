package com.zeeshan.service;

import java.util.List;

import com.zeeshan.model.User;

public interface UserService {

	public List<User> getAll();

	public User getOne(Long id);

	public User createUser(User user);

	public boolean deleteUser(Long id);

	public User update(User user);
}
