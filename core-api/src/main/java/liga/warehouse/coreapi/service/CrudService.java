package liga.warehouse.coreapi.service;

import java.util.Set;

public interface CrudService<T> {

    T findById(Long id);

    void save(T entity);

    T deleteById(Long id);

    Set<T> findAll();

    void update(T entity);

}
