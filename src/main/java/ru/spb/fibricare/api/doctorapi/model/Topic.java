package ru.spb.fibricare.api.doctorapi.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "patientcontrol", name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "time_create")
    private Date startTime;
    @Column(name = "period_push")
    private Integer remindPeriodHours;
    @Column(name = "text")
    private String text;
    @OneToMany(mappedBy = "topic")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Feedback> Feedbacks;
}
