package ru.spb.fibricare.api.doctorapi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.Visit;
import ru.spb.fibricare.api.doctorapi.repository.VisitRepository;
import ru.spb.fibricare.api.doctorapi.service.auxiliary.PageFinder;

@Service
public class VisitServiceImpl extends AbstractCrudService<Visit, Long>
        implements VisitService {
    protected final PageFinder<Visit> byPatientIdFinder;
    protected final PageFinder<Visit> byDoctorIdFinder;

    public VisitServiceImpl(VisitRepository repository,
            EntityDtoFactory<Visit, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
        
        this.byPatientIdFinder = PageFinder.<Visit>builder()
            .withFactory(dtoFactory)
            .withExtractor(repository::findAllByPatientId)
            .build();
        this.byDoctorIdFinder = PageFinder.<Visit>builder()
            .withFactory(dtoFactory)
            .withExtractor(repository::findAllByDoctorId)
            .build();
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<Visit> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId) {
        return byPatientIdFinder.findPage(pageRequestDto, patientId);
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<Visit> findAllByDoctorId(PageRequestDto pageRequestDto, Long doctorId) {
        return byDoctorIdFinder.findPage(pageRequestDto, doctorId);
    }
    
}
