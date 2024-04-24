package ru.spb.fibricare.api.doctorapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.ChadsScale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChadsScaleDto implements EntityDto<ChadsScale, Long> {
    @NotNull
    private Long patientId;
    @NotNull
    private Boolean hasHeartFailureOrDisfunction;
    @NotNull
    private Boolean hasArterialHypertension;
    @NotNull
    private Boolean hasDiabetes;
    @NotNull
    private Boolean hadStroke;
    @NotNull
    private Boolean hasVascularDesease;

    @Override
    public ChadsScale from() {
        ChadsScale scale = new ChadsScale();

        scale.setHadStroke(hadStroke);
        scale.setHasArterialHypertension(hasArterialHypertension);
        scale.setHasDiabetes(hasDiabetes);
        scale.setHasHeartFailureOrDisfunction(hasHeartFailureOrDisfunction);
        scale.setHasVascularDesease(hasVascularDesease);
        scale.setPatientId(patientId);

        return scale;
    }

    @Override
    @JsonIgnore
    public Long getId() {
        return patientId;
    }

    @Override
    @JsonIgnore
    public void setId(Long id) {
        this.patientId = id;
    }

    @Override
    public ChadsScaleDto fill(ChadsScale obj) {
        this.setHadStroke(obj.getHadStroke());
        this.setHasArterialHypertension(obj.getHasArterialHypertension());
        this.setHasDiabetes(obj.getHasDiabetes());
        this.setHasHeartFailureOrDisfunction(obj.getHasHeartFailureOrDisfunction());
        this.setHasVascularDesease(obj.getHasVascularDesease());
        this.setPatientId(obj.getPatientId());

        return this;
    }
    
}
