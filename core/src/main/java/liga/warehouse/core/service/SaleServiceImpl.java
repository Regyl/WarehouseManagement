package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.repository.SaleRepository;
import liga.warehouse.coreapi.model.Sale;
import liga.warehouse.coreapi.service.SaleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;

    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Scheduled(cron = "0 0 * * *")
    public void unloadingDailySales() {
        Set<Sale> dailySales = repository.findAllDaily();
    }

    @Override
    public void update(Sale entity) {
        repository.update(entity);
    }

    @Override
    public Sale findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException.supplierOf(Sale.class, id));
    }

    @Override
    public void save(Sale entity) {
        repository.save(entity);
    }

    @Override
    public Sale deleteById(Long id) {
        Sale sale = findById(id);
        repository.deleteById(id);
        return sale;
    }

    @Override
    public Set<Sale> findAll() {
        return repository.findAll();
    }
}
