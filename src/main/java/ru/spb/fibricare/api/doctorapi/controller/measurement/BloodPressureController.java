package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.model.measurement.BloodPressure;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

@RestController
@RequestMapping("/bloodpressure")
public class BloodPressureController extends AbstractLongIdMeasurementReadController<BloodPressure> {

    public BloodPressureController(MeasurementService<BloodPressure, Long> readService) {
        super(readService);
    }
    
}
