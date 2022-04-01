package liga.warehouse.coreapi.service;

import liga.warehouse.coreapi.model.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Role findById(Long id);

    Role findByAuthority(String authority);

    Set<Role> findAll();

    void saveAll(Set<Role> roles);
}
