package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.model.measurement.Weight;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

@RestController
@RequestMapping("/weight")
public class WeightController extends AbstractLongIdMeasurementReadController<Weight> {

    public WeightController(MeasurementService<Weight, Long> readService) {
        super(readService);
    }
    
}
