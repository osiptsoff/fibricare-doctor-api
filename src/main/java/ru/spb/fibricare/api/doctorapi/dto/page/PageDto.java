package ru.spb.fibricare.api.doctorapi.dto.page;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.spb.fibricare.api.doctorapi.dto.ConvertableDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {
    protected List<? extends ConvertableDto<T>> data;
    protected Integer pageNumber;
    protected Integer totalPages;
}
