package de.tekup.data.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.Categorie;
import de.tekup.data.repositories.CategorieRepository;



@Service
public class CategorieServiceImpl implements CategorieService
{
	@Autowired
	private CategorieRepository ur;

	@Transactional
	@Override
	public MessageResponse save(Categorie cat) {
		
		boolean exist = ur.existsByNom(cat.getNom());
		if (exist) {return new MessageResponse(false, "Attention", "Email existe déjà!!");}
		
		ur.save(cat);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse update(Categorie cat) {
		Categorie us = findById(cat.getId());
		if (us == null) {return new MessageResponse(false, "Attention", "Categorie introuvable!!");}
		
		boolean exist = ur.existsByNom(cat.getNom());
		if (exist) {return new MessageResponse(false, "Attention", "Categorie existe déjà!!");}

		ur.save(cat);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Categorie cat = findById(id);
		if (cat == null) {
			return new MessageResponse(false, "Attention", "Utilisteaur introuvable!!");
		}

		ur.delete(cat);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Categorie> findAll() {
		return ur.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public 	Categorie findById(Long id) {
		return ur.findById(id).orElse(null);
	}

}
