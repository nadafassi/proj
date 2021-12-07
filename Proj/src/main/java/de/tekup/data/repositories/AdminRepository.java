package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{

}
