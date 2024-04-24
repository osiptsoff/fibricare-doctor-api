package ru.spb.fibricare.api.doctorapi.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.dto.HasBledScaleDto;
import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleRequest;
import ru.spb.fibricare.api.doctorapi.dto.request.CalculateScaleResponse;
import ru.spb.fibricare.api.doctorapi.model.HasBledScale;
import ru.spb.fibricare.api.doctorapi.service.HasBledScaleService;

@RestController
@RequestMapping("/hasbled")
public class HasBledScaleController
        extends AbstractLongIdCrudController<HasBledScale, HasBledScaleDto> {
    private final HasBledScaleService service;

    public HasBledScaleController(HasBledScaleService service) {
        super(service);
        this.service = service;
    }
    
    @GetMapping("/{patientId}/calculate")
    public CalculateScaleResponse calculate(@PathVariable Long patientId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate) {
        var request = new CalculateScaleRequest(patientId, null, birthDate);
        var response = service.calculateScale(request);
        
        return new CalculateScaleResponse(response);
    }
}
