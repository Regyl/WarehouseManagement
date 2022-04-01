package liga.warehouse.core.service;

import liga.warehouse.core.repository.SaleRepository;
import liga.warehouse.coreapi.service.SaleService;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository repository;

    public SaleServiceImpl(SaleRepository repository) {
        this.repository = repository;
    }


}
