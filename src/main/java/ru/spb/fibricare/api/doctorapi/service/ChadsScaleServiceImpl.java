package ru.spb.fibricare.api.doctorapi.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleRequest;
import ru.spb.fibricare.api.doctorapi.model.ChadsScale;
import ru.spb.fibricare.api.doctorapi.repository.ChadsScaleRepository;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

@Service
public class ChadsScaleServiceImpl extends AbstractCrudService<ChadsScale, Long>
        implements ChadsScaleService {

    public ChadsScaleServiceImpl(ChadsScaleRepository repository,
            EntityDtoFactory<ChadsScale, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }

    @Override
    public EntityDto<ChadsScale, Long> save(EntityDto<ChadsScale, Long> obj) {
        return dtoFactory.instantiate(upsert(obj.from()));
    }

    @Override
    @Transactional(readOnly = true)
    public Integer calculateScale(CalculateScaleRequest request) throws MissingEntityException {
        var scaleOptional = repository.findById(request.getPatientId());
        if(!scaleOptional.isPresent()) {
            throw new MissingEntityException("Patient with given id has no scale data");
        }

        var scale = scaleOptional.get();

        Integer result = 0;
        result += scale.getHadStroke() ? 2 : 0;
        result += scale.getHasArterialHypertension() ? 1 : 0;
        result += scale.getHasDiabetes() ? 1 : 0;
        result += scale.getHasHeartFailureOrDisfunction() ? 1 : 0;
        result += scale.getHasVascularDesease() ? 1 : 0;
        result += request.getSex() == 2 ? 1 : 0;

        var fromDate = request.getBirthDate()
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
        var toDate = LocalDate.now();
        var years = Period.between(fromDate, toDate).getYears();
        result += years > 65 ? 1 : 0;
        result += years >= 75 ? 1 : 0;

        return result;
    }
    
}
