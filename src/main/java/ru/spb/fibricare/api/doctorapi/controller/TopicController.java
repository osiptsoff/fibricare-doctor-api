package ru.spb.fibricare.api.doctorapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.dto.TopicDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.Topic;
import ru.spb.fibricare.api.doctorapi.service.TopicService;

@RestController
@RequestMapping("/topic")
public class TopicController extends AbstractLongIdCrudController<Topic, TopicDto> {
    private final TopicService service;

    public TopicController(TopicService service) {
        super(service);
        this.service = service;
    }
    
    @GetMapping("/patient/{patientId}")
    public PageDto<Topic> read(@PathVariable Long patientId,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return service.findAllByPatientId(new PageRequestDto(pageNumber, pageSize), patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public PageDto<Topic> readByDoctor(@PathVariable Long doctorId,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return service.findAllByDoctorId(new PageRequestDto(pageNumber, pageSize), doctorId);
    }
}
