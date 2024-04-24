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
@Table(schema = "patientcontrol", name = "feedback_pulse")
public class Pulse extends Feedback {
    @Column(name = "pulse_rate_average")
    private Integer rate;
    @Column(name = "pulse_scale")
    private String scale;
}
