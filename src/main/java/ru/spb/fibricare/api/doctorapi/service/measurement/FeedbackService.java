package ru.spb.fibricare.api.doctorapi.service.measurement;

import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.service.ReadService;

public interface FeedbackService extends ReadService<Feedback, Long> {
    PageDto<Feedback> findPageByTopicId(PageRequestDto pageRequestDto, Long topicId);
}
