package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@NoRepositoryBean
public interface MeasurementRepository<T extends Feedback, U> extends PagingAndSortingRepository<T, U> {
    Page<T> findAllByPatientId(Pageable pageable, Long patientId);
}
