package com.mcapm.associados.domain.model.associates;

import com.mcapm.associados.domain.model.IdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Associate {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private OffsetDateTime createdAt;
    private String document;
    private String name;
    private AssociateStatus status;

    public static Associate brandNew(String name, String document) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(document);
        return new Associate(
                IdGenerator.generateTimeBasedUUID(),
                OffsetDateTime.now(),
                document,
                name,
                AssociateStatus.ACTIVE);

    }

    public void activeAssociate() {
        this.status = AssociateStatus.ACTIVE;
    }

    public void inactiveAssociate() {
        this.status = AssociateStatus.INACTIVE;
    }
}
