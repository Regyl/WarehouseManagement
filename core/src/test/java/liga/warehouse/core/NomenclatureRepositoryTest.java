package liga.warehouse.core;

import liga.warehouse.core.repository.NomenclatureRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NomenclatureRepositoryTest {

    @Autowired
    private NomenclatureRepository repository;

    @Test
    public void findById() {
        assertNotNull(repository);
        assertDoesNotThrow(() -> repository.findById(1L));
    }
}
