package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.repository.ProductRepository;
import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
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
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Set<Product> findAll() {
        return repository.findAll();
    }
}
