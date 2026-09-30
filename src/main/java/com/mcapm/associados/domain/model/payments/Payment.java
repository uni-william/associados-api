package com.mcapm.associados.domain.model.payments;

import com.mcapm.associados.domain.model.IdGenerator;
import com.mcapm.associados.domain.model.associates.Associate;
import com.mcapm.associados.domain.model.associates.AssociateStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "associate_id")
    private Associate associate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    private BigDecimal amount;

    public static Payment brandNew(Associate associate, LocalDate dueDate, BigDecimal amount) {
        Objects.requireNonNull(associate);
        Objects.requireNonNull(dueDate);
        Objects.requireNonNull(amount);
        return new Payment(
                IdGenerator.generateTimeBasedUUID(),
                associate,
                dueDate,
                null,
                amount
                );
    }

    public void confirmPayment(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

}
