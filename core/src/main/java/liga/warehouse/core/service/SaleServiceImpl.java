package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.repository.DailySaleRepository;
import liga.warehouse.core.repository.SaleRepository;
import liga.warehouse.coreapi.model.DailySale;
import liga.warehouse.coreapi.model.Sale;
import liga.warehouse.coreapi.service.SaleService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;
    private final DailySaleRepository dailySaleRepository;

    public SaleServiceImpl(SaleRepository repository, DailySaleRepository dailySaleRepository) {
        this.repository = repository;
        this.dailySaleRepository = dailySaleRepository;
    }

    @Override
    @Scheduled(cron = "0 0 * * *")
    public void unloadingDailySales() {
        List<Float> dailySales = repository.findAllDaily().stream()
                .map(Sale::getSum)
                .collect(Collectors.toList());
        Float resultSum = 0F;
        for(Float item : dailySales) {
            resultSum+=item;
        }

        DailySale dailySale = DailySale.builder()
                .date(LocalDate.now())
                .sum(resultSum)
                .build();
        dailySaleRepository.save(dailySale);
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
