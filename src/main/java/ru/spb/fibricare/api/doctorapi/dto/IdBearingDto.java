package ru.spb.fibricare.api.doctorapi.dto;

public interface IdBearingDto<T> {
    T getId();
    void setId(T id);
}