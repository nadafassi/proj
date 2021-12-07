package de.tekup.data.services;

import java.util.List;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.User;

public interface UserService {
//	User save(User user);
//	List<User> getAllUsers();
//	UserResponse getUserById(long id);
//	User modifyUser(long id, User user);
//	User deleteUserById(long id);
	
	public MessageResponse save(User user);

	public MessageResponse update(User user);

	public MessageResponse delete(Long id);

	public List<User> findAll();

	public User findById(Long id);
	 
}
