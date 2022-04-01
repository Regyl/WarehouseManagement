package liga.warehouse.core.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException {

    private static String obtainCause(Class<?> entity, Long id) {
        return String.format("Entity of type %s with id %s not found", entity.getSimpleName(), id);
    }

    public EntityNotFoundException(Class<?> entity, Long id) {
        super(obtainCause(entity, id));
    }

    public static Supplier<EntityNotFoundException> supplierOf(Class<?> entity, Long id) {
        return () -> new EntityNotFoundException(entity, id);
    }
}
