package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.model.measurement.PhysicalActivity;
import ru.spb.fibricare.api.doctorapi.repository.measurement.PhysicalActivityRepository;

@Service
public class PhysicalActivityService extends AbstractMeasurementReadService<PhysicalActivity, Long> {

    public PhysicalActivityService(PhysicalActivityRepository repository,
            EntityDtoFactory<PhysicalActivity, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }
    
}
