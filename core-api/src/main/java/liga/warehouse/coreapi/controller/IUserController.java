package liga.warehouse.coreapi.controller;

import liga.warehouse.dto.request.UserDto;
import liga.warehouse.dto.response.UserDtoResponse;

public interface IUserController extends CrudController<UserDto, UserDtoResponse> {
}
