package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface RoleRepository {

    Optional<Role> findById(Long id);

    Optional<Role> findByAuthority(String authority);

    Set<Role> findAll();

    int saveAll(Set<Role> roles);
}
