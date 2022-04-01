package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Nomenclature;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


public class NomenclatureMyBatisTest extends MyBatisTest {

    @Autowired
    private NomenclatureRepository repository;

    @Test
    public void findById() {
        assertNotNull(repository);
        assertDoesNotThrow(() -> repository.findById(1L));
    }

    @Test
    public void save() {
        Nomenclature nomenclature = FACTORY.manufacturePojo(Nomenclature.class);
        assertDoesNotThrow(() -> repository.save(nomenclature));
    }
}
