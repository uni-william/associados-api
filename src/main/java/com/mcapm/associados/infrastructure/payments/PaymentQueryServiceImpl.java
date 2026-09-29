package com.mcapm.associados.infrastructure.payments;

import com.mcapm.associados.application.associates.query.PaymentOutput;
import com.mcapm.associados.application.associates.query.PaymentQueryService;
import com.mcapm.associados.application.utility.Mapper;
import com.mcapm.associados.domain.model.payments.PaymentNotFoundException;
import com.mcapm.associados.domain.model.payments.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentQueryServiceImpl implements PaymentQueryService {

    private final PaymentRepository paymentRepository;
    private final Mapper mapper;
    @Override
    public PaymentOutput findOne(UUID paymentId) {
        return paymentRepository.findById(paymentId)
                .map(payment -> mapper.convert(payment, PaymentOutput.class))
                .orElseThrow(PaymentNotFoundException::new);
    }

    @Override
    public List<PaymentOutput> findByAssociateId(UUID associateId) {
        return paymentRepository.findByAssociateId(associateId)
                .stream()
                .map(payment -> mapper.convert(payment, PaymentOutput.class))
                .toList();
    }

    @Override
    public List<PaymentOutput> findByAssociateIdAndBetweenDueDate(UUID associateId, LocalDate begin, LocalDate end) {
        return paymentRepository.findByAssociateIdAndBetweenDueDate(associateId, begin, end)
                .stream()
                .map(payment -> mapper.convert(payment, PaymentOutput.class))
                .toList();
    }
}
