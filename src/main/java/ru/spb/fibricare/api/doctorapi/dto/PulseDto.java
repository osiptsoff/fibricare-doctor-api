package ru.spb.fibricare.api.doctorapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.model.measurement.Pulse;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PulseDto implements EntityDto<Pulse, Long> {
    private FeedbackDto feedback;
    private Integer rate;
    private String scale;

    @Override
    public Pulse from() {
        Feedback fb = feedback.from();
        Pulse obj = new Pulse();

        obj.setRate(rate);
        obj.setScale(scale);
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
    public PulseDto fill(Pulse obj) {
        feedback = (new FeedbackDto()).fill(obj);

        this.setRate(obj.getRate());
        this.setScale(obj.getScale());

        return this;
    }
}
