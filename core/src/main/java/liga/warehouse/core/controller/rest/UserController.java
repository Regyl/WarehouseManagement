package liga.warehouse.core.controller.rest;

import liga.warehouse.core.controller.mapper.UserMapper;
import liga.warehouse.coreapi.controller.IUserController;
import liga.warehouse.coreapi.model.User;
import liga.warehouse.coreapi.service.UserService;
import liga.warehouse.dto.request.UserDto;
import liga.warehouse.dto.response.UserDtoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController implements IUserController {

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public UserDtoResponse deleteById(Long id) {
        User user = service.deleteById(id);
        return mapper.toDto(user);
    }

    @Override
    public Set<UserDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public UserDtoResponse findById(Long id) {
        User user = service.findById(id);
        return mapper.toDto(user);
    }

    @Override
    public void save(UserDto dto) {
        User user = mapper.toEntity(dto);
        service.save(user);
    }

    @Override
    public void updateById(Long id, UserDto dto) {
        User user = service.findById(id);
        mapper.update(dto, user);
        service.save(user);
    }
}
