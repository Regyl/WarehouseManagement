package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface RoleRepository extends CrudRepository<Role> {

    Optional<Role> findByAuthority(String authority);

    int saveAll(Set<Role> roles);
}
