package liga.warehouse.coreapi.repository;

import java.util.Optional;
import java.util.Set;

public interface CrudRepository<T> {

    Optional<T> findById(Long id);

    int save(T entity);

    void deleteById(Long id);

    Set<T> findAll();

    boolean update(T entity);
}
