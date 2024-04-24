package ru.spb.fibricare.api.doctorapi.controller.measurement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.spb.fibricare.api.doctorapi.controller.AbstractLongIdReadController;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;
import ru.spb.fibricare.api.doctorapi.service.measurement.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController extends AbstractLongIdReadController<Feedback>  {
    private final FeedbackService service;
    
    public FeedbackController(FeedbackService service) {
        super(service);
        this.service = service;
    }
    
    @GetMapping("/topic/{topicId}")
    public PageDto<Feedback> read(@PathVariable Long topicId,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return service.findPageByTopicId(new PageRequestDto(pageNumber, pageSize), topicId);
    }
}
