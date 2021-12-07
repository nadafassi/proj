package de.tekup.data.services;

import java.util.List;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.Categorie;


public interface CategorieService {
	public MessageResponse save(Categorie categorie);

	public MessageResponse update(Categorie categorie);

	public MessageResponse delete(Long id);

	public List<Categorie> findAll();

	public Categorie findById(Long id);
	 
}
