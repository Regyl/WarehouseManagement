package liga.warehouse.dto.response;

import liga.warehouse.dto.enumeration.Authority;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDtoResponse extends AbstractDtoResponse {

    private String authority;

}
