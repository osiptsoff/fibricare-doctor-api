package ru.spb.fibricare.api.doctorapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.measurement.Complaints;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintsDto implements EntityDto<Complaints, Long> {
    private FeedbackDto feedback;
    private String complaints;

    @Override
    public Complaints from() {
        Feedback fb = feedback.from();
        Complaints obj = new Complaints();

        obj.setComplaints(complaints);
        obj.setDate(fb.getDate());
        obj.setId(fb.getId());
        obj.setPatientId(fb.getPatientId());
        obj.setTopic(fb.getTopic());

        return obj;
    }

    @Override
    @JsonIgnore
    public Long getId() {
        return feedback.getId();
    }

    @Override
    @JsonIgnore
    public void setId(Long id) {
        this.feedback.setId(id);
    }

    @Override
    public ComplaintsDto fill(Complaints obj) {
        feedback = (new FeedbackDto()).fill(obj);

        this.setComplaints(obj.getComplaints());

        return this;
    }
}
