package liga.warehouse.coreapi.model;

import liga.warehouse.dto.enumeration.Authority;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends AbstractEntity implements GrantedAuthority {

    private Authority authority;

    public String getAuthority() {
        return authority.name();
    }
}
