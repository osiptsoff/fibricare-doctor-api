package ru.spb.fibricare.api.doctorapi.service;

import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.Topic;

public interface TopicService extends CrudService<Topic, Long> {
    PageDto<Topic> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId);
    PageDto<Topic> findAllByDoctorId(PageRequestDto pageRequestDto, Long doctorId);
}
