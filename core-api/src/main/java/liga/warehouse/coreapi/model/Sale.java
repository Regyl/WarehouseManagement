package liga.warehouse.coreapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sale extends AbstractEntity {

    private Product product;

    private LocalDateTime timestamp;

    private Double quantity;

    private Float sum;
}
