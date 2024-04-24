package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ru.spb.fibricare.api.doctorapi.controller.AbstractLongIdReadController;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

public class AbstractLongIdMeasurementReadController<T> extends AbstractLongIdReadController<T> {
    private final MeasurementService<T, Long> service;

    public AbstractLongIdMeasurementReadController(MeasurementService<T, Long> readService) {
        super(readService);
        this.service = readService;
    }

    @GetMapping("/patient/{patientId}")
    public PageDto<T> read(@PathVariable Long patientId,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return service.findAllByPatientId(new PageRequestDto(pageNumber, pageSize), patientId);
    }
}
