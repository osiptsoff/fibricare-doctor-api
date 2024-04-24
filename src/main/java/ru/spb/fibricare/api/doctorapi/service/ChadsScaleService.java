package ru.spb.fibricare.api.doctorapi.service;

import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleRequest;
import ru.spb.fibricare.api.doctorapi.model.ChadsScale;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

public interface ChadsScaleService extends CrudService<ChadsScale, Long> {
    public Integer calculateScale(CalculateScaleRequest request) throws MissingEntityException;
}
