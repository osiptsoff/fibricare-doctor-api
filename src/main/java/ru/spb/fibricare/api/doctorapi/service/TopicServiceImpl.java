package ru.spb.fibricare.api.doctorapi.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.Topic;
import ru.spb.fibricare.api.doctorapi.repository.TopicRepository;
import ru.spb.fibricare.api.doctorapi.service.auxiliary.PageFinder;

@Service
public class TopicServiceImpl extends AbstractCrudService<Topic, Long>
        implements TopicService {
    protected final PageFinder<Topic> byPatientIdFinder;
    protected final PageFinder<Topic> byDoctorIdFinder;

    public TopicServiceImpl(TopicRepository repository,
            EntityDtoFactory<Topic, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
        
        this.byPatientIdFinder = PageFinder.<Topic>builder()
            .withFactory(dtoFactory)
            .withExtractor(repository::findAllByPatientId)
            .build();
        this.byDoctorIdFinder = PageFinder.<Topic>builder()
            .withFactory(dtoFactory)
            .withExtractor(repository::findAllByDoctorId)
            .build();
    }

    @Override
    protected Topic upsert(Topic obj) {
        if(obj.getStartTime() == null) {
            obj.setStartTime(new Date());
        }
        
        return repository.save(obj);
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<Topic> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId) {
        return byPatientIdFinder.findPage(pageRequestDto, patientId);
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<Topic> findAllByDoctorId(PageRequestDto pageRequestDto, Long doctorId) {
        return byDoctorIdFinder.findPage(pageRequestDto, doctorId);
    }

}
