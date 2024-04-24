package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.model.measurement.Pulse;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

@RestController
@RequestMapping("/pulse")
public class PulseController extends AbstractLongIdMeasurementReadController<Pulse>  {

    public PulseController(MeasurementService<Pulse, Long> readService) {
        super(readService);
    }
    
}
