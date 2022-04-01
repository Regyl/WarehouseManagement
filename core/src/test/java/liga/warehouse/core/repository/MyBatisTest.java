package liga.warehouse.core.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Slf4j
@MybatisTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class MyBatisTest {

    protected static final PodamFactory FACTORY;

    static {
        FACTORY = new PodamFactoryImpl();
    }
}
