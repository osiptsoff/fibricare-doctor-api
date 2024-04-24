package ru.spb.fibricare.api.doctorapi.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;

import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

public interface CrudService<T, U> extends ReadService<T, U> {
    EntityDto<T, U> save(EntityDto<T, U> obj) throws DuplicateKeyException,
        DataIntegrityViolationException;
    EntityDto<T, U> update(EntityDto<T, U> obj) throws MissingEntityException,
        DataIntegrityViolationException;
    void deleteOneById(U id) throws MissingEntityException;
}
