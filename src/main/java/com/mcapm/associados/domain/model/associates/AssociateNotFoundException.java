package com.mcapm.associados.domain.model.associates;

import com.mcapm.associados.domain.model.DomainException;

public class AssociateNotFoundException extends DomainException {
    public AssociateNotFoundException() {
    }

    public AssociateNotFoundException(Throwable cause) {
        super(cause);
    }

    public AssociateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssociateNotFoundException(String message) {
        super(message);
    }
}