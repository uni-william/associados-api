package com.mcapm.associados.application.associates.management;

import com.mcapm.associados.application.associates.query.AssociateOutput;
import com.mcapm.associados.domain.model.associates.Associate;
import com.mcapm.associados.domain.model.associates.AssociateNotFoundException;
import com.mcapm.associados.domain.model.associates.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AssociateManagementApplicationService {

    private final AssociateRepository associateRepository;

    @Transactional
    public AssociateOutput create(AssociateInput input) {
        Associate associate = Associate.brandNew(input.getName(), input.getDocument());
        return AssociateOutput.from(associateRepository.saveAndFlush(associate));
    }
    @Transactional
    public void delete(UUID id) {
        Associate associate = associateRepository.findById(id).orElseThrow(AssociateNotFoundException::new);
        associateRepository.delete(associate);
    }
    @Transactional
    public void activeAssociate(UUID id, boolean active) {
        Associate associate = associateRepository.findById(id).orElseThrow(AssociateNotFoundException::new);
        if (active) {
            associate.activeAssociate();
        } else {
            associate.inactiveAssociate();
        }
        associateRepository.saveAndFlush(associate);
    }
}
