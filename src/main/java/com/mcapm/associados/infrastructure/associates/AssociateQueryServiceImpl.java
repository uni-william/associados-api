package com.mcapm.associados.infrastructure.associates;

import com.mcapm.associados.application.associates.query.AsscoaiteBirthDaysOutput;
import com.mcapm.associados.application.associates.query.AssociateOutput;
import com.mcapm.associados.application.associates.query.AssociateQueryService;
import com.mcapm.associados.application.utility.Mapper;
import com.mcapm.associados.domain.model.associates.AssociateNotFoundException;
import com.mcapm.associados.domain.model.associates.AssociateRepository;
import com.mcapm.associados.domain.model.associates.AssociateStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    @Override
    public List<AsscoaiteBirthDaysOutput> findAllBirthDays(LocalDate date) {
        LocalDate limite = date.plusDays(15);

        return associateRepository.findAll()
                .stream()
                .filter(associate -> {
                    LocalDate nascimento = associate.getBirthDate();

                    int diaAnoNascimento = nascimento.getDayOfYear();
                    int diaAnoHoje = date.getDayOfYear();
                    int diaAnoLimite = limite.getDayOfYear();

                    if (diaAnoHoje <= diaAnoLimite) {
                        return diaAnoNascimento >= diaAnoHoje
                                && diaAnoNascimento <= diaAnoLimite;
                    }

                    return diaAnoNascimento >= diaAnoHoje
                            || diaAnoNascimento <= diaAnoLimite;
                })
                .map(AsscoaiteBirthDaysOutput::from)
                .toList();
    }

    @Override
    public List<AsscoaiteBirthDaysOutput> findAllBirthToday(LocalDate date) {
        LocalDate limite = date.plusDays(0);

        return associateRepository.findAll()
                .stream()
                .filter(associate -> {
                    LocalDate nascimento = associate.getBirthDate();

                    int diaAnoNascimento = nascimento.getDayOfYear();
                    int diaAnoHoje = date.getDayOfYear();
                    int diaAnoLimite = limite.getDayOfYear();

                    if (diaAnoHoje <= diaAnoLimite) {
                        return diaAnoNascimento >= diaAnoHoje
                                && diaAnoNascimento <= diaAnoLimite;
                    }

                    return diaAnoNascimento >= diaAnoHoje
                            || diaAnoNascimento <= diaAnoLimite;
                })
                .map(AsscoaiteBirthDaysOutput::from)
                .toList();
    }

    @Override
    public List<AssociateOutput> findAllActive() {
        return associateRepository.findAllByStatusOrderByNameAsc(AssociateStatus.ACTIVE)
                .stream()
                .map(associate -> mapper.convert(associate, AssociateOutput.class))
                .toList();
    }
}
