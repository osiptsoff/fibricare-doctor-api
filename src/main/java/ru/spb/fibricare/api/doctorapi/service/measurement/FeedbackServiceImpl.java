package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.repository.measurement.FeedbackRepository;
import ru.spb.fibricare.api.doctorapi.service.AbstractReadService;
import ru.spb.fibricare.api.doctorapi.service.auxiliary.PageFinder;

@Service
public class FeedbackServiceImpl extends AbstractReadService<Feedback, Long>
        implements FeedbackService {
    protected final PageFinder<Feedback> finder;

    public FeedbackServiceImpl(FeedbackRepository repository,
            EntityDtoFactory<Feedback, Long> dtoFactory) {
        super(repository, repository, dtoFactory);

        this.finder = PageFinder.<Feedback>builder()
            .withFactory(dtoFactory)
            .withExtractor(repository::findAllByTopicId)
            .build();
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<Feedback> findPageByTopicId(PageRequestDto pageRequestDto, Long topicId) {
        return finder.findPage(pageRequestDto, topicId);
    }
    
}
