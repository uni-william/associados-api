package com.mcapm.associados.domain.model.associates;

import com.mcapm.associados.domain.model.Address;
import com.mcapm.associados.domain.model.IdGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "associate")
public class Associate {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private String name;
    private String document;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String email;
    private String phone;
    @Column(name = "blood_type")
    private String bloodType;
    private String contact;
    @Column(name = "phone_contact")
    private String phoneContact;
    @Enumerated(EnumType.STRING)
    private AssociateStatus status;
    @Embedded
    private Address address;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public static Associate brandNew(String name, String document, LocalDate birthDate, String email, String phone, String bloodType, String contact, String phoneContact, Address address) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(document);
        Objects.requireNonNull(birthDate);
        Objects.requireNonNull(email);
        Objects.requireNonNull(phone);
        Objects.requireNonNull(bloodType);
        Objects.requireNonNull(address);
        Objects.requireNonNull(contact);
        Objects.requireNonNull(phoneContact);
        return new Associate(
                IdGenerator.generateTimeBasedUUID(),
                name,
                document,
                birthDate,
                email,
                phone,
                bloodType,
                contact,
                phoneContact,
                AssociateStatus.ACTIVE,
                address,
                OffsetDateTime.now());

    }

    public void activeAssociate() {
        this.status = AssociateStatus.ACTIVE;
    }

    public void inactiveAssociate() {
        this.status = AssociateStatus.INACTIVE;
    }
}
