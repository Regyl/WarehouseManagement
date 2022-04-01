package liga.warehouse.coreapi.service;

import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.model.Sale;

public interface ProductService extends CrudService<Product> {

    void sale(Sale sale);
}
