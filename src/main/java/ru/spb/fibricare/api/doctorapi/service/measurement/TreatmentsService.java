package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.model.measurement.Treatments;
import ru.spb.fibricare.api.doctorapi.repository.measurement.TreatmentsRepository;

@Service
public class TreatmentsService extends AbstractMeasurementReadService<Treatments, Long> {

    public TreatmentsService(TreatmentsRepository repository,
            EntityDtoFactory<Treatments, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }
    
}
