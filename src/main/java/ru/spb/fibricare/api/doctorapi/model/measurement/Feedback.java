package ru.spb.fibricare.api.doctorapi.model.measurement;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.Topic;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(schema = "patientcontrol", name = "feedback")
public class Feedback {
    @Id
    @Column(name = "feedback_id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
