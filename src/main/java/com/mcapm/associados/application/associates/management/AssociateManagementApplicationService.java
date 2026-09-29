package com.mcapm.associados.application.associates.management;

import com.mcapm.associados.application.associates.query.AssociateOutput;
import com.mcapm.associados.domain.model.Address;
import com.mcapm.associados.domain.model.associates.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AssociateManagementApplicationService {

    private final AssociateRepository associateRepository;


    public AssociateOutput create(AssociateInput input) {
        Associate associate = Associate.brandNew(
                input.getName(),
                input.getDocument(),
                input.getBirthDate(),
                input.getEmail(),
                input.getPhone(),
                input.getBloodType(),
                input.getContact(),
                input.getPhoneContact(),
                Address.builder()
                        .street(input.getAddress().getStreet())
                        .complement(input.getAddress().getComplement())
                        .neighborhood(input.getAddress().getNeighborhood())
                        .number(input.getAddress().getNumber())
                        .city(input.getAddress().getCity())
                        .state(input.getAddress().getState())
                        .zipCode(input.getAddress().getZipCode())
                        .build());
        return AssociateOutput.from(associateRepository.saveAndFlush(associate));
    }
    public void delete(UUID id) {
        Associate associate = associateRepository.findById(id).orElseThrow(AssociateNotFoundException::new);
        associateRepository.delete(associate);
    }

    public void active(UUID id) {
        Associate associate = associateRepository.findById(id).orElseThrow(AssociateNotFoundException::new);
        associate.activeAssociate();
        associateRepository.save(associate);
    }

    public void inactive(UUID id) {
        Associate associate = associateRepository.findById(id).orElseThrow(AssociateNotFoundException::new);
        associate.inactiveAssociate();
        associateRepository.save(associate);
    }
}
