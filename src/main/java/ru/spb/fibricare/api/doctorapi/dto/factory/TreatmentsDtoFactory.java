package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.TreatmentsDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Treatments;

@Component
public class TreatmentsDtoFactory implements EntityDtoFactory<Treatments, Long> {

    @Override
    public TreatmentsDto instantiate() {
        return new TreatmentsDto();
    }

    @Override
    public TreatmentsDto instantiate(Treatments obj) {
        return new TreatmentsDto().fill(obj);
    }
    
}
