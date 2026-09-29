package com.mcapm.associados.application.associates.management;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssociateInput {
    @NotBlank
    private String name;
    @NotBlank
    private String document;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String contact;
    @NotBlank
    private String phoneContact;
    @NotBlank
    private String bloodType;
    @NotNull
    @Past
    private LocalDate birthDate;
    @NotNull
    @Valid
    private AddressData address;
}
