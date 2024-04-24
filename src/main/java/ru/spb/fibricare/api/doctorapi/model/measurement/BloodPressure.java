package ru.spb.fibricare.api.doctorapi.model.measurement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "patientcontrol", name = "feedback_blood_pressure")
public class BloodPressure extends Feedback {
    @Column(name = "blood_pressure_sist")
    private Integer systolic;
    @Column(name = "blood_pressure_diast")
    private Integer diastolic;
}
