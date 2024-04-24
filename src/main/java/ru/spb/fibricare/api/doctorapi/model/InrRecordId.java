package ru.spb.fibricare.api.doctorapi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable()
public class InrRecordId {
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "record_time")
    private Date date;
}
