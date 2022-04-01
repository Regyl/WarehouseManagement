package liga.warehouse.core.repository;

import java.util.Set;

public interface CrudRepository<T> {

    T findById(Long id);

    T save(T entity);

    void deleteById(Long id);

    Set<T> findAll();
}
