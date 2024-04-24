package ru.spb.fibricare.api.doctorapi.service;

import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.Visit;

public interface VisitService extends CrudService<Visit, Long> {
    PageDto<Visit> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId);
    PageDto<Visit> findAllByDoctorId(PageRequestDto pageRequestDto, Long doctorId);
}
