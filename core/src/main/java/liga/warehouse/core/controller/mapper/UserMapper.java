package liga.warehouse.core.controller.mapper;

import liga.warehouse.coreapi.model.User;
import liga.warehouse.dto.request.UserDto;
import liga.warehouse.dto.response.AbstractDtoResponse;
import liga.warehouse.dto.response.UserDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {

    public UserMapper(ModelMapper mapper) {
        super(mapper);
    }

    @Override
    public User toEntity(UserDto dto) {
        return mapper.map(dto, User.class);
    }

    @Override
    public UserDtoResponse toDto(User entity) {
        return mapper.map(entity, UserDtoResponse.class);
    }

    @Override
    public void update(UserDto source, User destination) {
        mapper.map(source, destination);
    }
}
