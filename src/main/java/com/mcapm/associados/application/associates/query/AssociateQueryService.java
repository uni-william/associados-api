package com.mcapm.associados.application.associates.query;

import java.util.List;
import java.util.UUID;

public interface AssociateQueryService {
    AssociateOutput findOne(UUID associateId);
    AssociateOutput findByDocument(String document);
    List<AssociateOutput> findAll();
}
