package com.mcapm.associados.domain.model.associates;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssociateRepository extends JpaRepository<Associate, UUID> {

    Optional<Associate> findByDocument(String document);
    List<Associate> findAllByStatusOrderByNameAsc(AssociateStatus status);
}
