package ru.spb.fibricare.api.doctorapi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.Topic;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto implements EntityDto<Feedback, Long> {
    private Long id;
    private Long patientId;
    private Date date;
    private Long topicId;

    @Override
    public Feedback from() {
        Feedback feedback = new Feedback();

        Topic topic = null;
        if(topicId != null) {
            topic = new Topic();
            topic.setId(topicId);
        }
        
        feedback.setId(id);
        feedback.setPatientId(patientId);
        feedback.setDate(date);
        feedback.setTopic(topic);

        return feedback;
    }

    @Override
    public FeedbackDto fill(Feedback obj) {
        this.setId(obj.getId());
        this.setPatientId(obj.getPatientId());
        this.setDate(obj.getDate());
        this.setTopicId(obj.getTopic() == null ? null : obj.getTopic().getId());

        return this;
    }
    
}
