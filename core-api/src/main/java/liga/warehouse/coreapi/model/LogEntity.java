package liga.warehouse.coreapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class LogEntity extends AbstractEntity {

    private LocalDateTime timestamp;

    private String fullName;

    private String username;

}
