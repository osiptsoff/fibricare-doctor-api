package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.model.measurement.PhysicalActivity;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

@RestController
@RequestMapping("/activity")
public class PhysicalActivityController
        extends AbstractLongIdMeasurementReadController<PhysicalActivity> {

    public PhysicalActivityController(MeasurementService<PhysicalActivity, Long> readService) {
        super(readService);
    }
    
}
