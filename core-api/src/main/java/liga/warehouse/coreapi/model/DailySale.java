package liga.warehouse.coreapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class DailySale extends AbstractEntity {

    private LocalDate date;

    private Float sum;
}
