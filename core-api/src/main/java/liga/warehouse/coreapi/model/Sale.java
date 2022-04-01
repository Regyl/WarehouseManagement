package liga.warehouse.coreapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class Sale extends AbstractEntity {

    private Product product;

    private LocalDateTime timestamp;

    private Double quantity;

    private Float sum;
}
