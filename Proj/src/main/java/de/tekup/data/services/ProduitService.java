package de.tekup.data.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.Produit;

public interface ProduitService {
	public MessageResponse save(Produit pdt);

	public MessageResponse update(Produit pdt);

	public MessageResponse delete(Long id);

	public List<Produit> findAll();

	public Produit findById(Long id);
	
	public MessageResponse louer (Long id);
	
	public MessageResponse liberer (Long id);
	
	public MessageResponse acheter (Long id);
}
