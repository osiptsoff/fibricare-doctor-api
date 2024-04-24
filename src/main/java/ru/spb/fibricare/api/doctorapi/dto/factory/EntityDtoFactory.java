package ru.spb.fibricare.api.doctorapi.dto.factory;

import ru.spb.fibricare.api.doctorapi.dto.EntityDto;

public interface EntityDtoFactory<T, U> {
    EntityDto<T, U> instantiate();
    EntityDto<T, U> instantiate(T obj);
}

