package com.mcapm.associados.presentation;

import com.mcapm.associados.application.associates.management.PaymentAssociateInput;
import com.mcapm.associados.application.associates.management.PaymentManagementApplicationService;
import com.mcapm.associados.application.associates.query.PaymentOutput;
import com.mcapm.associados.application.associates.query.PaymentQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentManagementApplicationService paymentManagementApplicationService;
    private final PaymentQueryService paymentQueryService;

    @PostMapping("/byAssociate")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid PaymentAssociateInput input) {
        paymentManagementApplicationService.createPaymentByAssociateId(input.getAssociateId(), input.getMonthBegin(), input.getYear());
    }

    @GetMapping("/byAssociateYear")
    public List<PaymentOutput> findByAssociateYear(@RequestParam UUID associateId,
                                                   @RequestParam Integer year) {
        LocalDate begin = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        return paymentQueryService.findByAssociateIdAndDueDateBetween(associateId, begin, end);
    }

    @PutMapping("/{associateId}/confirmPayment")
    @ResponseStatus(HttpStatus.OK)
    public PaymentOutput confirmPayment(@PathVariable UUID associateId,
                                        @RequestParam LocalDate paymentDate) {
        return paymentManagementApplicationService.confirmPaymentDate(associateId, paymentDate);
    }
}
