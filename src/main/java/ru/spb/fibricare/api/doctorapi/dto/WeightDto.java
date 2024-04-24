package ru.spb.fibricare.api.doctorapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.model.measurement.Weight;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeightDto implements EntityDto<Weight, Long> {
    private FeedbackDto feedback;
    private Integer weight;

    @Override
    public Weight from() {
        Feedback fb = feedback.from();
        Weight obj = new Weight();

        obj.setWeight(weight);
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
    public WeightDto fill(Weight obj) {
        feedback = (new FeedbackDto()).fill(obj);

        this.setWeight(obj.getWeight());

        return this;
    }
}
