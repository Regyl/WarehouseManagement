package liga.warehouse.coreapi.service;

import java.util.Set;

public interface CrudService<T> {

    T findById(Long id);

    void save(T entity);

    void deleteById(Long id);

    Set<T> findAll();

}
