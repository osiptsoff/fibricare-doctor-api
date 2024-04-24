package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.model.measurement.BloodPressure;
import ru.spb.fibricare.api.doctorapi.repository.measurement.BloodPressureRepository;

@Service
public class BloodPressureService extends AbstractMeasurementReadService<BloodPressure, Long> {

    public BloodPressureService(BloodPressureRepository repository,
            EntityDtoFactory<BloodPressure, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }
    
}
