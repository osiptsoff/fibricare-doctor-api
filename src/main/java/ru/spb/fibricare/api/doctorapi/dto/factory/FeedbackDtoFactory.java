package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.FeedbackDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@Component
public class FeedbackDtoFactory implements EntityDtoFactory<Feedback, Long> {

    @Override
    public FeedbackDto instantiate() {
        return new FeedbackDto();
    }

    @Override
    public FeedbackDto instantiate(Feedback obj) {
        return new FeedbackDto().fill(obj);
    }
    
}