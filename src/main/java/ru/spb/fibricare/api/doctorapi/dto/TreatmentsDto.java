package ru.spb.fibricare.api.doctorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.model.measurement.Treatments;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentsDto implements EntityDto<Treatments, Long> {
    private FeedbackDto feedback;
    private String treatments;

    @Override
    public Treatments from() {
        Feedback fb = feedback.from();
        Treatments obj = new Treatments();

        obj.setTreatments(treatments);
        obj.setDate(fb.getDate());
        obj.setId(fb.getId());
        obj.setPatientId(fb.getPatientId());
        obj.setTopic(fb.getTopic());

        return obj;
    }

    @Override
    public Long getId() {
        return feedback.getId();
    }

    @Override
    public void setId(Long id) {
        this.feedback.setId(id);
    }

    @Override
    public TreatmentsDto fill(Treatments obj) {
        feedback = (new FeedbackDto()).fill(obj);

        this.setTreatments(obj.getTreatments());

        return this;
    }
}
