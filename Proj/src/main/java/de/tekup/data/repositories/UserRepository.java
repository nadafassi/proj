
package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
	boolean existsByEmail(String email);
	boolean existsByPrenom(String prenom);
	boolean existsByNom(String nom);
	boolean existsByEmailAndId(String username, Long id);
	boolean existsByNomAndId(String nom, Long id);
}
