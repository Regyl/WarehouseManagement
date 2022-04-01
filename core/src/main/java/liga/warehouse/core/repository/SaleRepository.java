package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Sale;
import liga.warehouse.coreapi.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

@Mapper
public interface SaleRepository extends CrudRepository<Sale> {

    Set<Sale> findAllDaily();

}
