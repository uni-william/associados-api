package com.mcapm.associados.application.associates.management;

import com.mcapm.associados.application.associates.query.PaymentOutput;
import com.mcapm.associados.domain.model.associates.Associate;
import com.mcapm.associados.domain.model.associates.AssociateNotFoundException;
import com.mcapm.associados.domain.model.associates.AssociateRepository;
import com.mcapm.associados.domain.model.companies.Company;
import com.mcapm.associados.domain.model.companies.CompanyNotFoundException;
import com.mcapm.associados.domain.model.companies.CompanyRepository;
import com.mcapm.associados.domain.model.payments.Payment;
import com.mcapm.associados.domain.model.payments.PaymentNotFoundException;
import com.mcapm.associados.domain.model.payments.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentManagementApplicationService {

    private final PaymentRepository paymentRepository;
    private final CompanyRepository companyRepository;
    private final AssociateRepository associateRepository;

    private final String COMPANY_DOCUMENT = "38431538000123";

    public void createPaymentByAssociateId(UUID associateId, Integer monthBegin, Integer year) {
        Company company = companyRepository.findByDocument(COMPANY_DOCUMENT).orElseThrow(CompanyNotFoundException::new);
        Associate associate = associateRepository.findById(associateId).orElseThrow(AssociateNotFoundException::new);
        Integer dayBase = company.getDayBase();
        BigDecimal associateTax = company.getAssociateTax();
        for (int month = monthBegin; month <= 12; month++) {
            YearMonth yearMonth = YearMonth.of(year, month);
            int day = Math.min(dayBase, yearMonth.lengthOfMonth());
            LocalDate date = LocalDate.of(year, month, day);
            if (!paymentRepository.existsByAssociateIdAndDueDate(associateId, date)) {
                Payment payment = Payment.brandNew(associate, date, associateTax);
                paymentRepository.save(payment);
            }
        }

    }

    public PaymentOutput confirmPaymentDate(UUID paymentId, LocalDate paymentDate) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(PaymentNotFoundException::new);
        payment.confirmPayment(paymentDate);
        paymentRepository.save(payment);
        return PaymentOutput.from(payment);
    }
}
