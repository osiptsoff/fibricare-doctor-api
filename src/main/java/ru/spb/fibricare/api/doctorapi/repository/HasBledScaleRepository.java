package ru.spb.fibricare.api.doctorapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.HasBledScale;

@Repository
public interface HasBledScaleRepository extends CrudRepository <HasBledScale, Long>,
        PagingAndSortingRepository<HasBledScale, Long>{
}
