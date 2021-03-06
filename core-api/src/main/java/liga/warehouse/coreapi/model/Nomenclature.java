package liga.warehouse.coreapi.model;

import liga.warehouse.dto.enumeration.FrequencyType;
import liga.warehouse.dto.enumeration.ProductType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class Nomenclature extends AbstractEntity {

    private String name;

    private ProductType productType;

    private FrequencyType frequencyType;

    private String country;

    private LocalDateTime createTimestamp;

}
