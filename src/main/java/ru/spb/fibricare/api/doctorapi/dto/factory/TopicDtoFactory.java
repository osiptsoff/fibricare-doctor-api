package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.TopicDto;
import ru.spb.fibricare.api.doctorapi.model.Topic;

@Component
public class TopicDtoFactory implements EntityDtoFactory<Topic, Long> {

    @Override
    public TopicDto instantiate() {
        return new TopicDto();
    }

    @Override
    public TopicDto instantiate(Topic obj) {
        return new TopicDto().fill(obj);
    }
    
}