package com.mcapm.associados.application.associates.management;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentAssociateInput {

    @NotNull
    private UUID associateId;
    @NotNull
    @Min(1)
    @Max(12)
    private Integer monthBegin;
    @NotNull
    private Integer year;
}
