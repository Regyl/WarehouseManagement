package liga.warehouse.coreapi.service;

import liga.warehouse.coreapi.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<User>, UserDetailsService {
}
