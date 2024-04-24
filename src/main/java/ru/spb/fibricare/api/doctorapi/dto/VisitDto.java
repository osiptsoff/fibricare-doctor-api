package ru.spb.fibricare.api.doctorapi.dto;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.Visit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto implements EntityDto<Visit, Long> {
    private Long id;
    @NotNull
    private Long patientId;
    @NotNull
    private Long doctorId;
    private Date date;
    private String patientComplaints;
    private String examinationResult;
    private String diagnosis;
    private String assignedTreatment;

    @Override
    public Visit from() {
        Visit visit = new Visit();

        visit.setAssignedTreatment(assignedTreatment);
        visit.setDate(date);
        visit.setDiagnosis(diagnosis);
        visit.setDoctorId(doctorId);
        visit.setExaminationResult(examinationResult);
        visit.setId(id);
        visit.setPatientComplaints(patientComplaints);
        visit.setPatientId(patientId);

        return visit;
    }

    @Override
    public VisitDto fill(Visit obj) {
        this.setAssignedTreatment(obj.getAssignedTreatment());
        this.setDate(obj.getDate());
        this.setDiagnosis(obj.getDiagnosis());
        this.setDoctorId(obj.getDoctorId());
        this.setExaminationResult(obj.getExaminationResult());
        this.setId(obj.getId());
        this.setPatientComplaints(obj.getPatientComplaints());
        this.setPatientId(obj.getPatientId());

        return this;
    }
    
}
