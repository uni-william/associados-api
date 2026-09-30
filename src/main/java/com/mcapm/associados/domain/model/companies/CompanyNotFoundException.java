package com.mcapm.associados.domain.model.companies;

import com.mcapm.associados.domain.model.DomainException;

public class CompanyNotFoundException extends DomainException {
    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(Throwable cause) {
        super(cause);
    }

    public CompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }
}