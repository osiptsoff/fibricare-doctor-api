package ru.spb.fibricare.api.doctorapi.service;

import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleRequest;
import ru.spb.fibricare.api.doctorapi.model.HasBledScale;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

public interface HasBledScaleService extends CrudService<HasBledScale, Long> {
    public Integer calculateScale(CalculateScaleRequest request) throws MissingEntityException;
}
