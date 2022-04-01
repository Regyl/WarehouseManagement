package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository extends CrudRepository<Product> {
}
