package liga.warehouse.coreapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractEntity {

    private Nomenclature nomenclature;

    private Float cost;

    private Double quantity;

    private LocalDate expiresAt;
}
