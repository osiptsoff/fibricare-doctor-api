package ru.spb.fibricare.api.doctorapi.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.InrRecord;
import ru.spb.fibricare.api.doctorapi.model.InrRecordId;
import ru.spb.fibricare.api.doctorapi.repository.InrRecordRepository;
import ru.spb.fibricare.api.doctorapi.service.auxiliary.PageFinder;

@Service
public class InrRecordServiceImpl extends AbstractCrudService<InrRecord, InrRecordId>
        implements InrRecordService {
    private final PageFinder<InrRecord> finder;

    public InrRecordServiceImpl(InrRecordRepository repository,
            EntityDtoFactory<InrRecord, InrRecordId> dtoFactory) {
        super(repository, repository, dtoFactory);
        this.finder = PageFinder.<InrRecord>builder()
            .withFactory(dtoFactory)
            .withExtractor(repository::findAllByPatientId)
            .build();
    }

    @Override
    public EntityDto<InrRecord, InrRecordId> save(EntityDto<InrRecord, InrRecordId> obj) {
        var InrRecord = obj.from();
        InrRecord.setDate(new Date());

        return dtoFactory.instantiate(upsert(InrRecord));
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<InrRecord> findAllByPatientId(PageRequestDto pageRequestDto, Long patientId) {
        return finder.findPage(pageRequestDto, patientId);
    }
}
