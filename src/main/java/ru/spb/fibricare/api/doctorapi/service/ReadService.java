package ru.spb.fibricare.api.doctorapi.service;


import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

public interface ReadService<T, U>  {
    EntityDto<T, U> getOneByid(U id) throws MissingEntityException;
    PageDto<T> findPage(PageRequestDto pageRequestDto);
}
