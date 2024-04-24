package ru.spb.fibricare.api.doctorapi.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculateScaleRequest {
    @NotNull
    private Long patientId;
    @NotNull
    private Byte sex;
    @NotNull
    private Date birthDate;
}
