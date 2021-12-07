package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long>{
	boolean existsByNom(String nom);
}
