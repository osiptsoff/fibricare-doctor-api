package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.model.measurement.Weight;
import ru.spb.fibricare.api.doctorapi.repository.measurement.WeightRepository;

@Service
public class WeightService extends AbstractMeasurementReadService<Weight, Long> {

    public WeightService(WeightRepository repository,
            EntityDtoFactory<Weight, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }
    
}
