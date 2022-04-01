package liga.warehouse.core.repository;

import liga.warehouse.coreapi.model.Nomenclature;
import liga.warehouse.coreapi.model.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductMyBatisTest extends MyBatisTest {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private NomenclatureRepository nomenclatureRepository;

    @Test
    public void findById() {
        assertNotNull(repository);
        assertDoesNotThrow(() -> repository.findById(1L));
    }

    @Test
    public void save() {
        Set<Nomenclature> nomenclatureSet = nomenclatureRepository.findAll();

        if(!nomenclatureSet.isEmpty()) {
            Product product = FACTORY.manufacturePojoWithFullData(Product.class);
            product.setExpiresAt(LocalDate.now());
            product.setNomenclature(nomenclatureSet.stream().findFirst().get());
            assertDoesNotThrow(() -> repository.save(product));
        }
    }
}
