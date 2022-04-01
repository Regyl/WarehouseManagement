package liga.warehouse.core.controller.mapper;

import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.service.RoleService;
import liga.warehouse.dto.request.RoleDto;
import liga.warehouse.dto.response.AbstractDtoResponse;
import liga.warehouse.dto.response.RoleDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper extends AbstractMapper<Role, RoleDto> {

    private final RoleService service;

    public RoleMapper(ModelMapper mapper, RoleService service) {
        super(mapper);
        this.service = service;
    }

    @Override
    public Role toEntity(RoleDto dto) {
        return mapper.map(dto, Role.class);
    }

    @Override
    public RoleDtoResponse toDto(Role entity) {
        return mapper.map(entity, RoleDtoResponse.class);
    }

    @Override
    public void update(RoleDto source, Role destination) {
        mapper.map(source, destination);
    }
}
