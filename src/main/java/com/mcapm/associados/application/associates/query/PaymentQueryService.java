package com.mcapm.associados.application.associates.query;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PaymentQueryService {
    PaymentOutput findOne(UUID paymentId);
    List<PaymentOutput> findByAssociateId(UUID associateId);
    List<PaymentOutput> findByAssociateIdAndBetweenDueDate(UUID associateId, LocalDate begin, LocalDate end);
}
