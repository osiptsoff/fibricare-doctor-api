package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.model.measurement.Treatments;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

@RestController
@RequestMapping("/treatments")
public class TreatmentsController extends AbstractLongIdMeasurementReadController<Treatments> {

    public TreatmentsController(MeasurementService<Treatments, Long> readService) {
        super(readService);
    }
    
}
