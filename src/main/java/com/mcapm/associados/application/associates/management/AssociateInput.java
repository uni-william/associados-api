package com.mcapm.associados.application.associates.management;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssociateInput {
    @NotBlank
    private String name;
    @NotBlank
    private String document;
}
