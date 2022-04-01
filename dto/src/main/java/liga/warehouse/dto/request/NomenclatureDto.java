package liga.warehouse.dto.request;

import liga.warehouse.dto.enumeration.FrequencyType;
import liga.warehouse.dto.enumeration.ProductType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NomenclatureDto {

    private String name;

    private ProductType productType;

    private FrequencyType frequencyType;

    private String country;

    private LocalDateTime createTimestamp;
}
