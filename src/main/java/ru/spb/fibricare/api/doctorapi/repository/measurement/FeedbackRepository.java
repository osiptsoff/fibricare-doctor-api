package ru.spb.fibricare.api.doctorapi.repository.measurement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ru.spb.fibricare.api.doctorapi.model.measurement.Feedback;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long>,
        PagingAndSortingRepository<Feedback, Long> {
    @Query(value = """
        SELECT f FROM Feedback f JOIN FETCH f.topic t
            WHERE t.id = :topicId AND TYPE(f) = Feedback
            ORDER BY f.date DESC""")
    Page<Feedback> findAllByTopicId(Pageable pageable, Long topicId);
    @Query(value = "SELECT f FROM Feedback f WHERE TYPE(f) = Feedback ORDER BY f.date DESC")
    Page<Feedback> findAll(Pageable pageable);
}
