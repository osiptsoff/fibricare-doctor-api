package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.measurement.Complaints;

@Repository
public interface ComplaintsRepository extends CrudRepository<Complaints, Long>,
        MeasurementRepository<Complaints, Long>  {
}
