package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.BloodPressureDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.BloodPressure;

@Component
public class BloodPressureDtoFactory implements EntityDtoFactory<BloodPressure, Long> {

    @Override
    public BloodPressureDto instantiate() {
        return new BloodPressureDto();
    }

    @Override
    public BloodPressureDto instantiate(BloodPressure obj) {
        return new BloodPressureDto().fill(obj);
    }
    
}
