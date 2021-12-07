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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.Produit;
import de.tekup.data.services.ProduitService;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private ProduitService service;

	@GetMapping
	public List<Produit> getAllProduits() {return service.findAll();}
	
	@GetMapping("/{id}")
	public Produit getProduitById(@PathVariable("id") long id) {return service.findById(id);}
	
	@PostMapping()
	public MessageResponse ajoutProduit(@RequestBody Produit pdt) {return service.save(pdt);}
	
	@DeleteMapping("/{id}")
	public MessageResponse deleteProduit(@PathVariable("id") long id) {return service.delete(id);}
	
	@PutMapping("/{id}")
	public MessageResponse updateProduit(@PathVariable("id") long id, @RequestBody Produit newpdt) {return service.update(newpdt);}
	//@RequestMapping(method=RequestMethod.POST)
	@PutMapping("/louer/{id}")
	public MessageResponse louerProduit(@PathVariable("id") long id, @RequestBody Produit newpdt) {return service.louer(id);}
	
	@PutMapping("/liberer/{id}")
	public MessageResponse libererProduit(@PathVariable("id") long id, @RequestBody Produit newpdt) {return service.liberer(id);}
	
	@PutMapping("/acheter/{id}")
	public MessageResponse acheterProduit(@PathVariable("id") long id, @RequestBody Produit newpdt) {return service.acheter(id);}
}
