package ru.spb.fibricare.api.doctorapi.service.measurement;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.repository.measurement.MeasurementRepository;
import ru.spb.fibricare.api.doctorapi.service.AbstractReadService;
import ru.spb.fibricare.api.doctorapi.service.auxiliary.PageFinder;

public abstract class AbstractMeasurementReadService<T extends Feedback, U>
        extends AbstractReadService<T, U> implements MeasurementService<T, U> {
    private final PageFinder<T> finder;

    public AbstractMeasurementReadService(CrudRepository<T, U> repository,
            MeasurementRepository<T, U> psRepository, EntityDtoFactory<T, U> dtoFactory) {
        super(repository, psRepository, dtoFactory);

        this.finder = PageFinder.<T>builder()
            .withFactory(dtoFactory)
            .withExtractor((pg, id) -> {
                var pga = PageRequest.of(pg.getPageNumber(), pg.getPageSize(),
                    Sort.by("date").descending());
                return psRepository.findAllByPatientId(pga, id);
            })
            .build();
    }
    
    @Override
    @Transactional(readOnly = true)
    public PageDto<T> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId) {
        return finder.findPage(pageRequestDto, patientId);
    }
}
