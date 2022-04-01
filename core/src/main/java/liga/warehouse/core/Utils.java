package liga.warehouse.core;

import liga.warehouse.coreapi.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    private Utils() {}

    public static User getAuthenticatedUser() {
        return ((User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal());
    }
}
