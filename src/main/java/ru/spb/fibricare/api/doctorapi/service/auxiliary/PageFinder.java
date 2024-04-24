package ru.spb.fibricare.api.doctorapi.service.auxiliary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ru.spb.fibricare.api.doctorapi.dto.factory.EntityDtoFactory;
import ru.spb.fibricare.api.doctorapi.dto.page.PageDto;
import ru.spb.fibricare.api.doctorapi.dto.page.PageRequestDto;

public final class PageFinder<T> {
    private final EntityDtoFactory<T, ?> dtoFactory;
    private final RawPageExtractor<T> pageExtractor;

    public static <V> PageFinderBuilder<V> builder() {
        return new PageFinderBuilder<V>();
    }

    private PageFinder(PageFinderBuilder<T> builder) {
        this.dtoFactory = builder.dtoFactory;
        this.pageExtractor = builder.pageExtractor;
    }

    public PageDto<T> findPage(PageRequestDto pageRequestDto, Long idParam) {
        Page<T> page;
        var pageRequest = PageRequest.of(pageRequestDto.getPageNumber(), pageRequestDto.getPageSize());

        page = pageExtractor.extract(pageRequest, idParam);

        var result = page.map(o -> dtoFactory.instantiate(o)).getContent();

        return new PageDto<>(result, page.getNumber(), page.getTotalPages());
    }

    public static class PageFinderBuilder<U> {
        private EntityDtoFactory<U, ?> dtoFactory;
        private RawPageExtractor<U> pageExtractor;

        private PageFinderBuilder() {
        }

        public PageFinderBuilder<U> withFactory(EntityDtoFactory<U, ?> dtoFactory) {
            this.dtoFactory = dtoFactory;

            return this;
        }

        public PageFinderBuilder<U> withExtractor(RawPageExtractor<U> pageExtractor) {
            this.pageExtractor = pageExtractor;

            return this;
        }

        public PageFinder<U> build() {
            if(dtoFactory == null || pageExtractor == null) {
                throw new NullPointerException("Attempt to create PageFinder with null member");
            }

            return new PageFinder<U>(this);
        }
    }

    @FunctionalInterface
    public interface RawPageExtractor<T> {
        Page<T> extract(Pageable pageable, Long parameter);
    }
}
