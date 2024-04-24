package ru.spb.fibricare.api.doctorapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import ru.spb.fibricare.api.doctorapi.dto.ConvertableDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.service.ReadService;

@RequiredArgsConstructor
public abstract class AbstractLongIdReadController<T> {
    private final ReadService<T, Long> readService;

    @GetMapping("")
    public PageDto<T> read(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return readService.findPage(new PageRequestDto(pageNumber, pageSize));
    }

    @GetMapping("/{id}")
    public ConvertableDto<T> read(@PathVariable Long id) {
        return readService.getOneByid(id);
    }
}
