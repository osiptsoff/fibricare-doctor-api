package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.PhysicalActivityDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.PhysicalActivity;

@Component
public class PhysicalActivityDtoFactory implements EntityDtoFactory<PhysicalActivity, Long> {

    @Override
    public PhysicalActivityDto instantiate() {
        return new PhysicalActivityDto();
    }

    @Override
    public PhysicalActivityDto instantiate(PhysicalActivity obj) {
        return new PhysicalActivityDto().fill(obj);
    }
    
}