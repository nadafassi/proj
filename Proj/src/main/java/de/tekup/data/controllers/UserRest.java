package de.tekup.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.User;
import de.tekup.data.services.UserService;

@RestController
@RequestMapping("/user")

public class UserRest {
	@Autowired
	private UserService service;

	@GetMapping
	public List<User> getAll() {return service.findAll();}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") long id) {return service.findById(id);}
	
	@PostMapping()
	public MessageResponse save(@RequestBody User user) {return service.save(user);}
	
	@DeleteMapping("/{id}")
	public MessageResponse deletePersonById(@PathVariable("id") long id) {return service.delete(id);}
	
	@PutMapping("/{id}")
	public MessageResponse updatePerson(@PathVariable("id") long id, @RequestBody User newUser) {return service.update(newUser);}
}
