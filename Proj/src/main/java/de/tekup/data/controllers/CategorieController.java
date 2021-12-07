package de.tekup.data.controllers;

import java.util.List;

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
import de.tekup.data.models.Categorie;
import de.tekup.data.services.CategorieService;

@RestController
@RequestMapping("/cat")
public class CategorieController {
	@Autowired
	private CategorieService service;

	@GetMapping
	public List<Categorie> getAll() {return service.findAll();}
	
	@GetMapping("/{id}")
	public Categorie getUserById(@PathVariable("id") long id) {return service.findById(id);}
	
	@PostMapping()
	public MessageResponse save(@RequestBody Categorie categorie) {return service.save(categorie);}
	
	@DeleteMapping("/{id}")
	public MessageResponse deletePersonById(@PathVariable("id") long id) {return service.delete(id);}
	
	@PutMapping("/{id}")
	public MessageResponse updatePerson(@PathVariable("id") long id, @RequestBody Categorie newUser) {return service.update(newUser);}
}
