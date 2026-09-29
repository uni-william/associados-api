package com.mcapm.associados.domain.model.payments;

import com.mcapm.associados.domain.model.DomainException;

public class PaymentNotFoundException extends DomainException {
    public PaymentNotFoundException() {
    }

    public PaymentNotFoundException(Throwable cause) {
        super(cause);
    }

    public PaymentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PaymentNotFoundException(String message) {
        super(message);
    }
}