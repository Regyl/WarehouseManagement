package liga.warehouse.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class SaleDto {

    @NotNull
    private Long productId;

    @NotNull
    private LocalDateTime timestamp;

    @NotNull
    private Double quantity;

}
