package liga.warehouse.dto.request;

import liga.warehouse.dto.enumeration.Authority;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {

    private Set<Authority> authorities;

    private String username;

    private String password;
}
