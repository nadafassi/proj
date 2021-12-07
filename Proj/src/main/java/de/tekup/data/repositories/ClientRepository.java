package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
