package ru.spb.fibricare.api.doctorapi.dto.factory;

import org.springframework.stereotype.Component;

import ru.spb.fibricare.api.doctorapi.dto.InrRecordDto;
import ru.spb.fibricare.api.doctorapi.model.InrRecord;
import ru.spb.fibricare.api.doctorapi.model.InrRecordId;

@Component
public class InrRecordDtoFactory implements EntityDtoFactory<InrRecord, InrRecordId> {

    @Override
    public InrRecordDto instantiate() {
        return new InrRecordDto();
    }

    @Override
    public InrRecordDto instantiate(InrRecord obj) {
        return new InrRecordDto().fill(obj);
    }
    
}