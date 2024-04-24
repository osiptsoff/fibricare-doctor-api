package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.ChadsScaleDto;
import ru.spb.fibricare.api.doctorapi.model.ChadsScale;

@Component
public class ChadsScaleDtoFactory implements EntityDtoFactory<ChadsScale, Long> {

    @Override
    public ChadsScaleDto instantiate() {
        return new ChadsScaleDto();
    }

    @Override
    public ChadsScaleDto instantiate(ChadsScale obj) {
        return new ChadsScaleDto().fill(obj);
    }
    
}
