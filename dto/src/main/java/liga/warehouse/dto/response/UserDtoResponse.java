package liga.warehouse.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDtoResponse extends AbstractDtoResponse {

    private Set<RoleDtoResponse> roles;

    private String username;

}
