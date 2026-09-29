package com.mcapm.associados.application.associates.query;

import com.mcapm.associados.domain.model.associates.Associate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsscoaiteBirthDaysOutput {
    private UUID id;
    private String name;
    private String phone;
    private String birthDate;

    public static AsscoaiteBirthDaysOutput from(Associate associate) {
        String diaMes = associate.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM"));
        return AsscoaiteBirthDaysOutput.builder()
                .id(associate.getId())
                .name(associate.getName())
                .phone(associate.getPhone())
                .birthDate(diaMes)
                .build();
    }
}
