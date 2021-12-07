package de.tekup.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.tekup.data.DTO.MessageResponse;
import de.tekup.data.models.Produit;
import de.tekup.data.models.Reserver;
import de.tekup.data.models.User;
import de.tekup.data.repositories.ProduitRepository;
import de.tekup.data.repositories.ReserverRepository;

@Service
public class ProduitServiceImpl implements ProduitService{
	@Autowired
	private ProduitRepository pr;

	@Transactional
	@Override
	public MessageResponse save(Produit pdt) {
		boolean exist = pr.existsByRef(pdt.getRef());
		if (exist) {return new MessageResponse(false, "Attention", "Produit existe déjà!!");}
		
		pr.save(pdt);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse update(Produit pdt) {
		Produit pd = findById(pdt.getId());
		if (pd == null) {return new MessageResponse(false, "Attention", "Produit introuvable!!");}
		
		boolean exist = pr.existsByRef(pdt.getRef());
		if (!exist) {if (pdt.getId()!=pd.getId()) {return new MessageResponse(false, "Attention", "Vous etes entrain de modifier un autre produit!!");}}
		
		pr.save(pdt);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse delete(Long id) {
		Produit pdt = findById(id);
		if (pdt == null) {return new MessageResponse(false, "Attention", "Produit introuvable!!");}

		pr.delete(pdt);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public List<Produit> findAll() {
		return pr.findAll();
	}

	@Transactional
	@Override
	public Produit findById(Long id) {
		return pr.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public MessageResponse louer (Long id) {
		Produit pd = findById(id);
		if (pd == null) {return new MessageResponse(false, "Attention", "Produit introuvable!!");}
		
		pd.setEtat("Réservé");
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}
	
	@Transactional
	@Override
	public MessageResponse liberer(Long id) {
		Produit pd = findById(id);
		if (pd == null) {return new MessageResponse(false, "Attention", "Produit introuvable!!");}
		
		pd.setEtat("Disponible");
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Transactional
	@Override
	public MessageResponse acheter(Long id) {
		Produit pd = findById(id);
		if (pd == null) {return new MessageResponse(false, "Attention", "Produit introuvable!!");}
		
		int quant = pd.getQuant();
		if (quant>1) {return new MessageResponse(false, "Attention", "Produit hors stock!!");}
		
		int newQuant= quant -1;
		pd.setQuant(newQuant);
		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

}