package ru.spb.fibricare.api.doctorapi.service.measurement;

import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.service.ReadService;

public interface MeasurementService<T, U> extends ReadService<T, U> {
    PageDto<T> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId);
}
