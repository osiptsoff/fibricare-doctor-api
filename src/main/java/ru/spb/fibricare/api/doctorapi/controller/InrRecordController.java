package ru.spb.fibricare.api.doctorapi.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ru.spb.fibricare.api.doctorapi.dto.ConvertableDto;
import ru.spb.fibricare.api.doctorapi.dto.InrRecordDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.model.InrRecord;
import ru.spb.fibricare.api.doctorapi.model.InrRecordId;
import ru.spb.fibricare.api.doctorapi.service.InrRecordService;

@RestController
@RequestMapping("/inr")
@RequiredArgsConstructor
public class InrRecordController {
    private final InrRecordService service;

    @GetMapping("")
    public PageDto<InrRecord> read(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return service.findPage(new PageRequestDto(pageNumber, pageSize));
    }

    @GetMapping("/patient/{patientId}")
    public PageDto<InrRecord> read(@PathVariable Long patientId,
            @RequestParam Integer pageNumber,
            @RequestParam Integer pageSize) {
        return service.findAllByPatientId(new PageRequestDto(pageNumber, pageSize), patientId);
    }

    @GetMapping("/{patientId}/{creationDate}")
    public ConvertableDto<InrRecord> read(@PathVariable Long patientId,
            @PathVariable @DateTimeFormat(iso = ISO.DATE_TIME) Date creationDate) {
        var id = new InrRecordId(patientId, creationDate);

        return service.getOneByid(id);
    }

    @PostMapping("")
    public ConvertableDto<InrRecord> create(@Valid @RequestBody InrRecordDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{patientId}/{creationDate}")
    public ConvertableDto<InrRecord> update(@PathVariable Long patientId, 
            @PathVariable @DateTimeFormat(iso = ISO.DATE_TIME) Date creationDate, 
            @Valid @RequestBody InrRecordDto dto) {
        var id = new InrRecordId(patientId, creationDate);
        dto.setId(id);
            
        return service.update(dto);
    }

    @DeleteMapping("/{patientId}/{creationDate}")
    public void delete(@PathVariable Long patientId, 
            @PathVariable @DateTimeFormat(iso = ISO.DATE_TIME) Date creationDate) {
        var id = new InrRecordId(patientId, creationDate);

        service.deleteOneById(id);
    }
}
