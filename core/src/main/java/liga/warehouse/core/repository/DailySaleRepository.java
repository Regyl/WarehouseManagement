package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.DailySale;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailySaleRepository {

    int save(DailySale entity);

}
