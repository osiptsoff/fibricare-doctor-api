package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.measurement.Weight;

@Repository
public interface WeightRepository extends CrudRepository<Weight, Long>,
        MeasurementRepository<Weight, Long>  {
}
