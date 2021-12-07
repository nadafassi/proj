package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.data.models.Categorie;
import de.tekup.data.models.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long>{
	boolean existsByRef(String ref);
}
