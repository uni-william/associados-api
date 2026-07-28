package com.mcapm.associados.presentation;

import com.mcapm.associados.application.associates.management.AssociateInput;
import com.mcapm.associados.application.associates.management.AssociateManagementApplicationService;
import com.mcapm.associados.application.associates.query.AssociateOutput;
import com.mcapm.associados.application.associates.query.AssociateQueryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/associates")
@RequiredArgsConstructor
public class AssociateController {

    private final AssociateManagementApplicationService associateManagementApplicationService;
    private final AssociateQueryService associateQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssociateOutput create(@RequestBody @Valid AssociateInput input) {
        return associateManagementApplicationService.create(input);
    }

    @GetMapping
    public List<AssociateOutput> findAll() {
        return associateQueryService.findAll();
    }

    @GetMapping("/{associateId}")
    public AssociateOutput findById(@PathVariable UUID associateId) {
        return associateQueryService.findOne(associateId);
    }

    @GetMapping("/document/{document}")
    public AssociateOutput findByDocument(@PathVariable String document) {
        return associateQueryService.findByDocument(document);
    }

    @DeleteMapping("/{associateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBiId(@PathVariable UUID associateId) {
        associateManagementApplicationService.delete(associateId);
    }
}
