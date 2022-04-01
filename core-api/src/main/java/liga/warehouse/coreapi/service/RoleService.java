package liga.warehouse.coreapi.service;

import liga.warehouse.coreapi.model.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService extends CrudService<Role> {

    Role findByAuthority(String authority);

    void saveAll(Set<Role> roles);
}
