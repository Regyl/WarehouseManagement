package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.model.User;
import liga.warehouse.coreapi.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;
import java.util.Set;

@Mapper
public interface UserRepository extends CrudRepository<User> {

    Optional<User> findByUsername(String username);

    int saveRoles(Long memberId, Set<Role> roles);
}
