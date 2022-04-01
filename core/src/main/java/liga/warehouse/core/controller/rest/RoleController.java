package liga.warehouse.core.controller.rest;

import liga.warehouse.core.annotations.Loggable;
import liga.warehouse.core.controller.mapper.RoleMapper;
import liga.warehouse.coreapi.controller.IRoleController;
import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.service.RoleService;
import liga.warehouse.dto.request.RoleDto;
import liga.warehouse.dto.response.RoleDtoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@Loggable
@RestController
@RequestMapping("/roles")
public class RoleController implements IRoleController {

    private final RoleService service;
    private final RoleMapper mapper;

    public RoleController(RoleService service, RoleMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public RoleDtoResponse deleteById(Long id) {
        Role role = service.deleteById(id);
        return mapper.toDto(role);
    }

    @Override
    public Set<RoleDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public RoleDtoResponse findById(Long id) {
        Role role = service.findById(id);
        return mapper.toDto(role);
    }

    @Override
    public void save(RoleDto dto) {
        Role role = mapper.toEntity(dto);
        service.save(role);
    }

    @Override
    public void updateById(Long id, RoleDto dto) {
        Role role = service.findById(id);
        mapper.update(dto, role);
        service.update(role);
    }
}
