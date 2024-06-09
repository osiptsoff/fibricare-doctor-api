package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.measurement.Treatments;

@Repository
public interface TreatmentsRepository extends CrudRepository<Treatments, Long>,
        MeasurementRepository<Treatments, Long>{
}
