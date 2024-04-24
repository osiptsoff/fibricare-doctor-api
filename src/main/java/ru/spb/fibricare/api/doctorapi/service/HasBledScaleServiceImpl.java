package ru.spb.fibricare.api.doctorapi.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleRequest;
import ru.spb.fibricare.api.doctorapi.model.HasBledScale;
import ru.spb.fibricare.api.doctorapi.repository.HasBledScaleRepository;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

@Service
public class HasBledScaleServiceImpl extends AbstractCrudService<HasBledScale, Long>
        implements HasBledScaleService {

    public HasBledScaleServiceImpl(HasBledScaleRepository repository,
            EntityDtoFactory<HasBledScale, Long> dtoFactory) {
        super(repository, repository, dtoFactory);
    }

    @Override
    public EntityDto<HasBledScale, Long> save(EntityDto<HasBledScale, Long> obj) {
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
        result += scale.getHadStroke() ? 1 : 0;
        result += scale.getHasBled() ? 1 : 0;
        result += scale.getHasHypertension() ? 1 : 0;
        result += scale.getHasKidneyDisfunction() ? 1 : 0;
        result += scale.getHasLabileInr() ? 1 : 0;
        result += scale.getHasLiverDisfunction() ? 1 : 0;
        result += scale.getTakingAlcohol() ? 1 : 0;
        result += scale.getTakingMedicines() ? 1 : 0;

        var fromDate = request.getBirthDate()
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
        var toDate = LocalDate.now();
        var years = Period.between(fromDate, toDate).getYears();
        result += years > 65 ? 1 : 0;

        return result;
    }
    
}
