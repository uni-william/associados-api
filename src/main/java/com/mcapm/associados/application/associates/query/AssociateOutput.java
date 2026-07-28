package com.mcapm.associados.application.associates.query;

import com.mcapm.associados.application.associates.management.AssociateInput;
import com.mcapm.associados.domain.model.associates.Associate;
import com.mcapm.associados.domain.model.associates.AssociateStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssociateOutput {

    private UUID id;
    private String document;
    private String name;
    private AssociateStatus status;

    public static AssociateOutput from(Associate associate) {
        return AssociateOutput.builder()
                .id(associate.getId())
                .document(associate.getDocument())
                .name(associate.getName())
                .status(associate.getStatus())
                .build();
    }
}
