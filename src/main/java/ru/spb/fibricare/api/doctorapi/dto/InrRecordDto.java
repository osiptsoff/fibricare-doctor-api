package ru.spb.fibricare.api.doctorapi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.model.InrRecord;
import ru.spb.fibricare.api.doctorapi.model.InrRecordId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InrRecordDto implements EntityDto<InrRecord, InrRecordId> {
    @NotNull
    private Long patientId;
    private Date date;
    @NotNull
    private Float inrValue;

    @Override
    public InrRecord from() {
        InrRecord record = new InrRecord();

        record.setId(getId());
        record.setInr(inrValue);

        return record;
    }

    @Override
    @JsonIgnore
    public InrRecordId getId() {
        return new InrRecordId(patientId, date);
    }

    @Override
    @JsonIgnore
    public void setId(InrRecordId id) {
        this.patientId = id.getPatientId();
        this.date = id.getDate();
    }

    @Override
    public InrRecordDto fill(InrRecord obj) {
        this.setDate(obj.getDate());
        this.setInrValue(obj.getInr());
        this.setPatientId(obj.getPatientId());

        return this;
    }
    
}
