package ru.spb.fibricare.api.doctorapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.model.measurement.PhysicalActivity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalActivityDto implements EntityDto<PhysicalActivity, Long> {
    private FeedbackDto feedback;
    private String activityDescription;

    @Override
    public PhysicalActivity from() {
        Feedback fb = feedback.from();
        PhysicalActivity obj = new PhysicalActivity();

        obj.setActivityDescription(activityDescription);
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
    public PhysicalActivityDto fill(PhysicalActivity obj) {
        feedback = (new FeedbackDto()).fill(obj);

        this.setActivityDescription(obj.getActivityDescription());

        return this;
    }
}
