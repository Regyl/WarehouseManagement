package liga.warehouse.core.controller.mapper;

import liga.warehouse.dto.response.AbstractDtoResponse;
import org.modelmapper.ModelMapper;

public abstract class AbstractMapper<T, S> {

    protected final ModelMapper mapper;

    AbstractMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public abstract T toEntity(S dto);

    public abstract AbstractDtoResponse toDto(T entity);
}
