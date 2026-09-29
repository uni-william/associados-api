package com.mcapm.associados.domain.model.companies;

import com.mcapm.associados.domain.model.Address;
import com.mcapm.associados.domain.model.IdGenerator;
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
@Table(name = "company")
public class Company {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private String name;
    private String document;
    private String email;
    private String phone;
    @Column(name = "associate_tax")
    private BigDecimal associateTax;
    @Column(name = "day_base")
    private Integer dayBase;
    @Embedded
    private Address address;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public static Company brandNew(String name, String document, String email, String phone, BigDecimal associateTax
            , Integer dayBase, Address address, LocalDate createdAt) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(document);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        Objects.requireNonNull(associateTax);
        Objects.requireNonNull(associateTax);
        Objects.requireNonNull(dayBase);
        return new Company(
                IdGenerator.generateTimeBasedUUID(),
                name,
                document,
                email,
                phone,
                associateTax,
                dayBase,
                address,
                createdAt);

    }
}
