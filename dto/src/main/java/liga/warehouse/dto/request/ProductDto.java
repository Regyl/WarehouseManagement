package liga.warehouse.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {

    private Long nomenclatureId;

    private Float cost;

    private Double quantity;

    private LocalDate expiresAt;
}
