package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.model.measurement.Complaints;
import ru.spb.fibricare.api.doctorapi.service.measurement.MeasurementService;

@RestController
@RequestMapping("/complaints")
public class ComplaintsController extends AbstractLongIdMeasurementReadController<Complaints> {

    public ComplaintsController(MeasurementService<Complaints, Long> readService) {
        super(readService);
    }
    
}
