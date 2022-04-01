package liga.warehouse.core.controller.mapper;

import liga.warehouse.coreapi.model.Nomenclature;
import liga.warehouse.dto.request.NomenclatureDto;
import liga.warehouse.dto.response.NomenclatureDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NomenclatureMapper extends AbstractMapper<Nomenclature, NomenclatureDto> {

    public NomenclatureMapper(ModelMapper mapper) {
        super(mapper);
    }

    @Override
    public Nomenclature toEntity(NomenclatureDto dto) {
        return mapper.map(dto, Nomenclature.class);
    }

    @Override
    public NomenclatureDtoResponse toDto(Nomenclature entity) {
        return mapper.map(entity, NomenclatureDtoResponse.class);
    }
}
