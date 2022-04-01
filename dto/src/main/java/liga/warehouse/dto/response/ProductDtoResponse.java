package liga.warehouse.dto.response;

import liga.warehouse.dto.request.ProductDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDtoResponse extends AbstractDtoResponse {

    private Long nomenclatureId;

    private Float cost;

    private Double quantity;

    private LocalDate expiresAt;
}
