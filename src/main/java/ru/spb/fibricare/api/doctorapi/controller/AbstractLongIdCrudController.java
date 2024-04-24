package ru.spb.fibricare.api.doctorapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import ru.spb.fibricare.api.doctorapi.dto.ConvertableDto;
import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.service.CrudService;

public class AbstractLongIdCrudController<T, U extends EntityDto<T, Long>>
        extends AbstractLongIdReadController<T> {
    private final CrudService<T, Long> service;

    public AbstractLongIdCrudController(CrudService<T, Long> service) {
        super(service);
        this.service = service;
    }

    @PostMapping("")
    public ConvertableDto<T> create(@Valid @RequestBody U dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ConvertableDto<T> update(@Valid @RequestBody U dto,
            @PathVariable Long id) {
        dto.setId(id);

        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteOneById(id);
    }
}
