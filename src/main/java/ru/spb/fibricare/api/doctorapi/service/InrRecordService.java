package ru.spb.fibricare.api.doctorapi.service;

import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.InrRecord;
import ru.spb.fibricare.api.doctorapi.model.InrRecordId;

public interface InrRecordService extends CrudService<InrRecord, InrRecordId> {
    PageDto<InrRecord> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId);

}
