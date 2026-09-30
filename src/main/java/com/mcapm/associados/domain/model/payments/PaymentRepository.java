package com.mcapm.associados.domain.model.payments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findByAssociateId(UUID associateId);
    List<Payment> findByAssociateIdAndDueDateBetween(UUID associateId, LocalDate begin,  LocalDate end);
    boolean existsByAssociateIdAndDueDate(UUID associateId, LocalDate dueDate
    );
}
