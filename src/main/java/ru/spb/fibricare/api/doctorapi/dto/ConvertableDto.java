package ru.spb.fibricare.api.doctorapi.dto;

public interface ConvertableDto<T> {
    T from();
    ConvertableDto<T> fill(T obj);
}
