package ru.spb.fibricare.api.doctorapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.Visit;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long>,
        PagingAndSortingRepository<Visit, Long> {
    @Query(value = "SELECT v FROM Visit v WHERE v.patientId = :patientId ORDER BY v.date DESC")
    Page<Visit> findAllByPatientId(Pageable pageable, Long patientId);
    @Query(value = "SELECT v FROM Visit v WHERE v.doctorId = :doctorId ORDER BY v.date DESC")
    Page<Visit> findAllByDoctorId(Pageable pageable, Long doctorId);
}
