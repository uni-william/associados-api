package com.mcapm.associados.domain.model.payments;

import com.mcapm.associados.domain.model.associates.Associate;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
}
