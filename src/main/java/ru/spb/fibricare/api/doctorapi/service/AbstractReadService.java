package ru.spb.fibricare.api.doctorapi.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AbstractReadService<T, U> implements ReadService<T, U> {
    protected final CrudRepository<T, U> repository;
    protected final PagingAndSortingRepository<T, U> psRepository;
    protected final EntityDtoFactory<T, U> dtoFactory;

    @Override
    public EntityDto<T, U> getOneByid(U id) throws MissingEntityException  {
        if(id == null) {
            throw new MissingEntityException("Entity not found");
        }

        var result = dtoFactory.instantiate();
        
        Optional<T> optional = repository.findById(id);
        if(!optional.isPresent()) {
            throw new MissingEntityException("Entity not found");
        }

        return result.fill(optional.get());
    }

    @Override
    public PageDto<T> findPage(PageRequestDto pageRequestDto) {
        Page<T> page;
        var pageRequest = PageRequest.of(pageRequestDto.getPageNumber(), pageRequestDto.getPageSize());

        page = psRepository.findAll(pageRequest);

        var result = page.map(o -> dtoFactory.instantiate(o)).getContent();

        return new PageDto<>(result, page.getNumber(), page.getTotalPages());
    }
}
