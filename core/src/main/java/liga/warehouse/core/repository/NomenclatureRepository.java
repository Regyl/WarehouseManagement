package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Nomenclature;
import liga.warehouse.coreapi.repository.CrudRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NomenclatureRepository extends CrudRepository<Nomenclature> {
}
