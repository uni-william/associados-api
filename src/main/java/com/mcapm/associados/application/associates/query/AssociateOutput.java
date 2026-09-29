package com.mcapm.associados.application.associates.query;

import com.mcapm.associados.application.associates.management.AddressData;
import com.mcapm.associados.domain.model.associates.Associate;
import com.mcapm.associados.domain.model.associates.AssociateStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociateOutput {

    private UUID id;
    private String name;
    private String document;
    private LocalDate birthDate;
    private String email;
    private String phone;
    private String bloodType;
    private String contact;
    private String phoneContact;
    private AssociateStatus status;
    private AddressData address;

    public static AssociateOutput from(Associate associate) {
        return AssociateOutput.builder()
                .id(associate.getId())
                .document(associate.getDocument())
                .birthDate(associate.getBirthDate())
                .email(associate.getEmail())
                .phone(associate.getPhone())
                .bloodType(associate.getBloodType())
                .contact(associate.getContact())
                .phoneContact(associate.getPhoneContact())
                .name(associate.getName())
                .status(associate.getStatus())
                .address(AddressData.builder()
                        .street(associate.getAddress().street())
                        .neighborhood(associate.getAddress().neighborhood())
                        .city(associate.getAddress().city())
                        .state(associate.getAddress().state())
                        .zipCode(associate.getAddress().zipCode())
                        .build())
                .build();
    }
}
