package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.HasBledScaleDto;
import ru.spb.fibricare.api.doctorapi.model.HasBledScale;

@Component
public class HasBledScaleDtoFactory implements EntityDtoFactory<HasBledScale, Long> {

    @Override
    public HasBledScaleDto instantiate() {
        return new HasBledScaleDto();
    }

    @Override
    public HasBledScaleDto instantiate(HasBledScale obj) {
        return new HasBledScaleDto().fill(obj);
    }
    
}