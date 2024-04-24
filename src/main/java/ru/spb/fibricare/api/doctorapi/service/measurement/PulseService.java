package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.model.measurement.Pulse;
import ru.spb.fibricare.api.doctorapi.repository.measurement.PulseRepository;

@Service
public class PulseService extends AbstractMeasurementReadService<Pulse, Long> {

    public PulseService(PulseRepository repository,
            EntityDtoFactory<Pulse, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }
    
}
