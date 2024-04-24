package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.measurement.BloodPressure;

@Repository
public interface BloodPressureRepository extends CrudRepository<BloodPressure, Long>,
        MeasurementRepository<BloodPressure, Long>  {
}
