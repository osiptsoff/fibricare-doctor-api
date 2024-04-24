package ru.spb.fibricare.api.doctorapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.InrRecord;
import ru.spb.fibricare.api.doctorapi.model.InrRecordId;

@Repository
public interface InrRecordRepository extends CrudRepository<InrRecord, InrRecordId>,
        PagingAndSortingRepository<InrRecord, InrRecordId> {
    @Query(value = """
        SELECT i FROM InrRecord i 
            WHERE i.id.patientId = :patientId 
            ORDER BY i.id.date DESC""")
    Page<InrRecord> findAllByPatientId(Pageable pageable, Long patientId);

}
