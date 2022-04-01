package liga.warehouse.core;

import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.service.RoleService;
import liga.warehouse.dto.enumeration.Authority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class Init {

    private final RoleService roleService;

    public Init(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {

        Set<Role> roles = roleService.findAll();
        if(roles.isEmpty()) {
            for(Authority authority : Authority.values()) {
                Role role = new Role();
                role.setAuthority(authority.name());
                roles.add(role);
            }
            roleService.saveAll(roles);
        }

    }
}
