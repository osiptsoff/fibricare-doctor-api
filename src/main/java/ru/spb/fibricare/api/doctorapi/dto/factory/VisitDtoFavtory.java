package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.VisitDto;
import ru.spb.fibricare.api.doctorapi.model.Visit;

@Component
public class VisitDtoFavtory implements EntityDtoFactory<Visit, Long> {

    @Override
    public VisitDto instantiate() {
        return new VisitDto();
    }

    @Override
    public VisitDto instantiate(Visit obj) {
        return new VisitDto().fill(obj);
    }
    
}