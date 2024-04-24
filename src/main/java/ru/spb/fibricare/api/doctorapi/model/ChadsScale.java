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
@Table(schema = "patient_research", name = "cha_scale_data")
public class ChadsScale {
    @Id
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "c")
    private Boolean hasHeartFailureOrDisfunction;
    @Column(name = "h")
    private Boolean hasArterialHypertension;
    @Column(name = "d")
    private Boolean hasDiabetes;
    @Column(name = "s")
    private Boolean hadStroke;
    @Column(name = "vasc")
    private Boolean hasVascularDesease;
}
