package ru.spb.fibricare.api.doctorapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.measurement.BloodPressure;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodPressureDto implements EntityDto<BloodPressure, Long> {
    private FeedbackDto feedback;
    private Integer systolic;
    private Integer diastolic;

    @Override
    public BloodPressure from() {
        Feedback fb = feedback.from();
        BloodPressure obj = new BloodPressure();

        obj.setDiastolic(diastolic);
        obj.setSystolic(systolic);
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
    public BloodPressureDto fill(BloodPressure obj) {
        feedback = feedback.fill(obj);

        this.setDiastolic(obj.getDiastolic());
        this.setSystolic(obj.getSystolic());

        return this;
    }
    
}
