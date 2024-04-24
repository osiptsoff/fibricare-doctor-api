package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.ComplaintsDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Complaints;

@Component
public class ComplaintsDtoFactory implements EntityDtoFactory<Complaints, Long> {

    @Override
    public ComplaintsDto instantiate() {
        return new ComplaintsDto();
    }

    @Override
    public ComplaintsDto instantiate(Complaints obj) {
        return new ComplaintsDto().fill(obj);
    }
    
}
