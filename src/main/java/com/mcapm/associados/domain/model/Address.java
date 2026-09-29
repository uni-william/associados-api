package com.mcapm.associados.domain.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.util.Objects;

@Embeddable
public record Address(
        @Column(name = "address_street")
        String street,
        @Column(name = "address_complement")
        String complement,
        @Column(name = "address_neighborhood")
        String neighborhood,
        @Column(name = "address_number")
        String number,
        @Column(name = "address_city")
        String city,
        @Column(name = "address_state")
        String state,
        @Column(name = "address_zip_code")
        String zipCode
) {
    @Builder(toBuilder = true)
    public Address {
        FieldValidations.requiresNonBlank(street);
        FieldValidations.requiresNonBlank(neighborhood);
        FieldValidations.requiresNonBlank(city);
        FieldValidations.requiresNonBlank(number);
        FieldValidations.requiresNonBlank(state);
        Objects.requireNonNull(zipCode);
    }
}
