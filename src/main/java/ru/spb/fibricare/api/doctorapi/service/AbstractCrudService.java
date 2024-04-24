package ru.spb.fibricare.api.doctorapi.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import ru.spb.fibricare.api.doctorapi.dto.EntityDto;
import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.service.exception.MissingEntityException;

@Transactional
public abstract class AbstractCrudService<T, U> extends AbstractReadService<T, U>
        implements CrudService<T, U> {
    public AbstractCrudService(CrudRepository<T, U> repository,
            PagingAndSortingRepository<T, U> psRepository,
            EntityDtoFactory<T, U> dtoFactory) {
        super(repository, psRepository, dtoFactory);
    }

    @Override
    public EntityDto<T, U> save(EntityDto<T, U> obj) throws DuplicateKeyException,
            DataIntegrityViolationException {
        T domainObj = obj.from();

        if(obj.getId() != null) {
            throw new DuplicateKeyException(
                "Id must not be assigned"
            );
        }

        return dtoFactory.instantiate(upsert(domainObj));
    }

    protected T upsert(T obj) {
        return repository.save(obj);
    }

    @Override
    public EntityDto<T, U> update(EntityDto<T, U> obj) throws MissingEntityException,
            DataIntegrityViolationException {
        T domainObj = obj.from();

        if(obj.getId() == null || !repository.existsById(obj.getId())) {
            throw new MissingEntityException(domainObj.getClass().getSimpleName() + " not found");
        }

        return obj.fill(upsert(domainObj));
    }

    @Override
    public void deleteOneById(U id) throws MissingEntityException {
        if(id == null || !repository.existsById(id)) {
            throw new MissingEntityException("Entity not found");
        }

        repository.deleteById(id);
    }
}
