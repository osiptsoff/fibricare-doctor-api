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
@Table(schema = "patientcontrol", name = "feedback_treatments")
public class Treatments extends Feedback {
    @Column(name = "treatments")
    private String treatments;
}
