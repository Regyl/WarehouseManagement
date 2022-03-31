package liga.warehouse.coreapi.model;

import liga.warehouse.coreapi.model.enumeration.ProductType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Nomenclature extends AbstractEntity {

    private String name;

    private ProductType type;

}
