package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.LogEntity;
import liga.warehouse.coreapi.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface LogEntityRepository extends CrudRepository<LogEntity> {
}
