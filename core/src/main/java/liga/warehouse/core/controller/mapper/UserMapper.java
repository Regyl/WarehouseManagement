package liga.warehouse.core.controller.mapper;

import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.model.User;
import liga.warehouse.coreapi.service.RoleService;
import liga.warehouse.dto.request.UserDto;
import liga.warehouse.dto.response.AbstractDtoResponse;
import liga.warehouse.dto.response.UserDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserMapper(ModelMapper mapper,
                      PasswordEncoder passwordEncoder, RoleService roleService) {
        super(mapper);
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User toEntity(UserDto dto) {
        User user = mapper.map(dto, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = dto.getAuthorities().stream()
                .map((item) -> roleService.findByAuthority(item.name()))
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return user;
    }

    @Override
    public UserDtoResponse toDto(User entity) {
        return mapper.map(entity, UserDtoResponse.class);
    }

    @Override
    public void update(UserDto source, User destination) {
        mapper.map(source, destination);
        if(source.getPassword() != null) {
            destination.setPassword(passwordEncoder.encode(source.getPassword()));
        }
    }
}
