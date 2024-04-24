package ru.spb.fibricare.api.doctorapi.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.dto.ChadsScaleDto;
import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleRequest;
import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleResponse;
import ru.spb.fibricare.api.doctorapi.model.ChadsScale;
import ru.spb.fibricare.api.doctorapi.service.ChadsScaleService;

@RestController
@RequestMapping("/chads")
public class ChadsScaleController extends AbstractLongIdCrudController<ChadsScale, ChadsScaleDto> {
    private final ChadsScaleService service;

    public ChadsScaleController(ChadsScaleService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/{patientId}/calculate")
    public CalculateScaleResponse calculate(@PathVariable Long patientId,
            @RequestParam Byte sex,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate) {
        var request = new CalculateScaleRequest(patientId, sex, birthDate);
        var response = service.calculateScale(request);
        
        return new CalculateScaleResponse(response);
    }
    
}
