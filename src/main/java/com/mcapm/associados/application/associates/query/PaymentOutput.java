package com.mcapm.associados.application.associates.query;

import com.mcapm.associados.domain.model.payments.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentOutput {

    private UUID id;
    private UUID asoociateId;
    private String name;
    private LocalDate dueDate;
    private LocalDate paymentDate;
    private BigDecimal amount;

    public static PaymentOutput from(Payment payment) {
        return PaymentOutput.builder()
                .id(payment.getId())
                .asoociateId(payment.getAssociate().getId())
                .name(payment.getAssociate().getName())
                .dueDate(payment.getDueDate())
                .paymentDate(payment.getPaymentDate())
                .amount(payment.getAmount())
                .build();
    }
}
