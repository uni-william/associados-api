package com.mcapm.associados.infrastructure.associates;

import com.mcapm.associados.application.associates.query.AssociateOutput;
import com.mcapm.associados.application.associates.query.AssociateQueryService;
import com.mcapm.associados.application.utility.Mapper;
import com.mcapm.associados.domain.model.associates.Associate;
import com.mcapm.associados.domain.model.associates.AssociateNotFoundException;
import com.mcapm.associados.domain.model.associates.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssociateQueryServiceImpl implements AssociateQueryService {

    private final AssociateRepository associateRepository;
    private final Mapper mapper;

    @Override
    public AssociateOutput findOne(UUID associateId) {
        return associateRepository.findById(associateId)
                .map(associate -> mapper.convert(associate, AssociateOutput.class))
                .orElseThrow(AssociateNotFoundException::new);
    }

    @Override
    public AssociateOutput findByDocument(String document) {
        return associateRepository.findByDocument(document)
                .map(associate -> mapper.convert(associate, AssociateOutput.class))
                .orElseThrow(AssociateNotFoundException::new);
    }

    @Override
    public List<AssociateOutput> findAll() {
        return associateRepository.findAll(Sort.by("name"))
                .stream()
                .map(associate -> mapper.convert(associate, AssociateOutput.class))
                .toList();
    }
}
