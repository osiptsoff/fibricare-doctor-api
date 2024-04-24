package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.model.measurement.Complaints;
import ru.spb.fibricare.api.doctorapi.repository.measurement.ComplaintsRepository;

@Service
public class ComplaintsService extends AbstractMeasurementReadService<Complaints, Long>{

    public ComplaintsService(ComplaintsRepository repository,
            EntityDtoFactory<Complaints, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }
    
}
