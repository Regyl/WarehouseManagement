package liga.warehouse.dto.response;

import liga.warehouse.dto.enumeration.FrequencyType;
import liga.warehouse.dto.enumeration.ProductType;
import liga.warehouse.dto.request.NomenclatureDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class NomenclatureDtoResponse extends AbstractDtoResponse {

    private String name;

    private ProductType productType;

    private FrequencyType frequencyType;

    private String country;

    private LocalDateTime createTimestamp;
}
