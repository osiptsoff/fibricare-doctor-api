package ru.spb.fibricare.api.doctorapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculateScaleResponse {
    private Integer scaleValue;
}
