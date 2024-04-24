package ru.spb.fibricare.api.doctorapi.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.Topic;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto implements EntityDto<Topic, Long> {
    private Long id;
    @NotNull
    private Long patientId;
    @NotNull
    private Long doctorId;
    private Date startTime;
    @NotNull
    private Integer remindPeriodHours;
    @NotBlank
    private String text;

    @Override
    public Topic from() {
        Topic topic = new Topic();

        topic.setStartTime(startTime);
        topic.setDoctorId(doctorId);
        topic.setId(id);
        topic.setPatientId(patientId);
        topic.setRemindPeriodHours(remindPeriodHours);
        topic.setText(text);

        return topic;
    }

    @Override
    public TopicDto fill(Topic obj) {
        this.setStartTime(obj.getStartTime());
        this.setDoctorId(obj.getDoctorId());
        this.setId(obj.getId());
        this.setPatientId(obj.getPatientId());
        this.setRemindPeriodHours(obj.getRemindPeriodHours());
        this.setText(obj.getText());

        return this;
    }
    
}
