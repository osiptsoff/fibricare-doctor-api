package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.measurement.PhysicalActivity;

@Repository
public interface PhysicalActivityRepository extends CrudRepository<PhysicalActivity, Long>,
        MeasurementRepository<PhysicalActivity, Long>  {
}

