package ru.spb.fibricare.api.doctorapi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "patient_research", name = "inr_record")
public class InrRecord {
    @EmbeddedId
    private InrRecordId id;
    @Column(name = "inr")
    private Float inr;

    public void setPatientId(Long ld) {
        if(id == null) {
            id = new InrRecordId();
        }

        id.setPatientId(ld);
    }

    public Long getPatientId() {
        if(id == null) {
            return null;
        }

        return id.getPatientId();
    }

    public void setDate(Date date) {
        if(id == null) {
            id = new InrRecordId();
        }

        id.setDate(date);
    }
    
    public Date getDate() {
        if(id == null) {
            return null;
        }

        return id.getDate();
    }
}
