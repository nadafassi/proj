package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.Reserver;

public interface ReserverRepository extends JpaRepository<Reserver,Long>{

}
