package ru.spb.fibricare.api.doctorapi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "patient_research", name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "date")
    private Date date;
    @Column(name = "complaints")
    private String patientComplaints;
    @Column(name = "examination")
    private String examinationResult;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "treatment")
    private String assignedTreatment;
}
