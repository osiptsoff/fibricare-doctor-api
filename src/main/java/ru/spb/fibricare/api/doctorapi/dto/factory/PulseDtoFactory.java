package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.PulseDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Pulse;

@Component
public class PulseDtoFactory implements EntityDtoFactory<Pulse, Long> {

    @Override
    public PulseDto instantiate() {
        return new PulseDto();
    }

    @Override
    public PulseDto instantiate(Pulse obj) {
        return new PulseDto().fill(obj);
    }
    
}