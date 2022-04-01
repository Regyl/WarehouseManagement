package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.exception.TooLowQuantityException;
import liga.warehouse.core.repository.ProductRepository;
import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.model.Sale;
import liga.warehouse.coreapi.service.ProductService;
import liga.warehouse.coreapi.service.SaleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final SaleService saleService;

    public ProductServiceImpl(ProductRepository repository, SaleService saleService) {
        this.repository = repository;
        this.saleService = saleService;
    }

    @Override
    public void sale(Sale sale) {
        Product product = sale.getProduct();
        double resultQuantity = product.getQuantity() - sale.getQuantity();
        if(resultQuantity < 0) {
            throw new TooLowQuantityException();
        }
        product.setQuantity(resultQuantity);
        update(product);

        saleService.save(sale);
    }

    @Override
    public void update(Product entity) {
        repository.update(entity);
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException.supplierOf(Product.class, id));

    }

    @Override
    public void save(Product entity) {
        repository.save(entity);
    }

    @Override
    public Product deleteById(Long id) {
        Product product = findById(id);
        repository.deleteById(id);
        return product;
    }

    @Override
    public Set<Product> findAll() {
        return repository.findAll();
    }
}
