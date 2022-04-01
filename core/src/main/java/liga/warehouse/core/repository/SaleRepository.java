package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Sale;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaleRepository extends CrudRepository<Sale> {
}
