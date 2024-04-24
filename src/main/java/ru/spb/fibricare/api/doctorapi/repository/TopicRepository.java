package ru.spb.fibricare.api.doctorapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long>,
        PagingAndSortingRepository<Topic, Long> {
    Page<Topic> findAllByPatientId(Pageable pageable, Long patientId);
    Page<Topic> findAllByDoctorId(Pageable pageable, Long doctorId);
}
