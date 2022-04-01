package liga.warehouse.coreapi.service;

import liga.warehouse.coreapi.model.Role;

import java.util.Optional;

public interface RoleService {

    Role findById(Long id);

    Role findByAuthority(String authority);
}
