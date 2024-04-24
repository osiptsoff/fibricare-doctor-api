package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.WeightDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Weight;

@Component
public class WeightDtoFactory implements EntityDtoFactory<Weight, Long> {

    @Override
    public WeightDto instantiate() {
        return new WeightDto();
    }

    @Override
    public WeightDto instantiate(Weight obj) {
        return new WeightDto().fill(obj);
    }
    
}