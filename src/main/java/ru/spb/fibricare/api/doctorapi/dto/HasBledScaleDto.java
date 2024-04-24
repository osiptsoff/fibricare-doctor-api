package ru.spb.fibricare.api.doctorapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.HasBledScale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HasBledScaleDto implements EntityDto<HasBledScale, Long> {
    @NonNull
    private Long patientId;
    @NonNull
    private Boolean hasHypertension;
    @NonNull
    private Boolean hasKidneyDisfunction;
    @NonNull
    private Boolean hasLiverDisfunction;
    @NonNull
    private Boolean hadStroke;
    @NonNull
    private Boolean hasBled;
    @NonNull
    private Boolean hasLabileInr;
    @NonNull
    private Boolean takingAlcohol;
    @NonNull
    private Boolean takingMedicines;

    @Override
    public HasBledScale from() {
        HasBledScale scale = new HasBledScale();

        scale.setHadStroke(hadStroke);
        scale.setHasBled(hasBled);
        scale.setHasHypertension(hasHypertension);
        scale.setHasKidneyDisfunction(hasKidneyDisfunction);
        scale.setHasLabileInr(hasLabileInr);
        scale.setHasLiverDisfunction(hasLiverDisfunction);
        scale.setPatientId(patientId);
        scale.setTakingAlcohol(takingAlcohol);
        scale.setTakingMedicines(takingMedicines);

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
    public HasBledScaleDto fill(HasBledScale obj) {
        this.setHadStroke(obj.getHadStroke());
        this.setHasBled(obj.getHasBled());
        this.setHasHypertension(obj.getHasHypertension());
        this.setHasKidneyDisfunction(obj.getHasKidneyDisfunction());
        this.setHasLabileInr(obj.getHasLabileInr());
        this.setHasLiverDisfunction(obj.getHasLiverDisfunction());
        this.setPatientId(obj.getPatientId());
        this.setTakingAlcohol(obj.getTakingAlcohol());
        this.setTakingMedicines(obj.getTakingMedicines());

        return this;
    }
    
}
