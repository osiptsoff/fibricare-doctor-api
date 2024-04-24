package ru.spb.fibricare.api.doctorapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "patient_research", name = "hasbled_scale_data")
public class HasBledScale {
    @Id
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "h")
    private Boolean hasHypertension;
    @Column(name = "a1")
    private Boolean hasKidneyDisfunction;
    @Column(name = "a2")
    private Boolean hasLiverDisfunction;
    @Column(name = "s")
    private Boolean hadStroke;
    @Column(name = "b")
    private Boolean hasBled;
    @Column(name = "l")
    private Boolean hasLabileInr;
    @Column(name = "d1")
    private Boolean takingAlcohol;
    @Column(name = "d2")
    private Boolean takingMedicines;
}
