package de.tekup.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.data.models.Message;

public interface MessageRepository extends JpaRepository<Message,Long>{

}
