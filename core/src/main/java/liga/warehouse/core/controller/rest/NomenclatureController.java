package liga.warehouse.core.controller.rest;

import liga.warehouse.core.controller.mapper.NomenclatureMapper;
import liga.warehouse.coreapi.controller.INomenclatureController;
import liga.warehouse.coreapi.model.Nomenclature;
import liga.warehouse.coreapi.service.NomenclatureService;
import liga.warehouse.dto.request.NomenclatureDto;
import liga.warehouse.dto.response.NomenclatureDtoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/nomenclature")
public class NomenclatureController implements INomenclatureController {

    private final NomenclatureService service;
    private final NomenclatureMapper mapper;

    public NomenclatureController(NomenclatureService service, NomenclatureMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public NomenclatureDtoResponse deleteById(Long id) {
        Nomenclature nomenclature = service.deleteById(id);
        return mapper.toDto(nomenclature);
    }

    @Override
    public Set<NomenclatureDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public NomenclatureDtoResponse findById(Long id) {
        Nomenclature nomenclature = service.findById(id);
        return mapper.toDto(nomenclature);
    }

    @Override
    public void save(NomenclatureDto dto) {
        Nomenclature nomenclature = mapper.toEntity(dto);
        service.save(nomenclature);
    }
}
