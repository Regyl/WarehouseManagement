package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.repository.NomenclatureRepository;
import liga.warehouse.coreapi.model.Nomenclature;
import liga.warehouse.coreapi.service.NomenclatureService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NomenclatureServiceImpl implements NomenclatureService {

    private final NomenclatureRepository repository;

    public NomenclatureServiceImpl(NomenclatureRepository repository) {
        this.repository = repository;
    }

    @Override
    public void update(Nomenclature entity) {
        repository.update(entity);
    }

    @Override
    public Nomenclature findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException.supplierOf(Nomenclature.class, id));
    }

    @Override
    public void save(Nomenclature entity) {
        repository.save(entity);
    }

    @Override
    public Nomenclature deleteById(Long id) {
        Nomenclature nomenclature = findById(id);
        repository.deleteById(id);
        return nomenclature;
    }

    @Override
    public Set<Nomenclature> findAll() {
        return repository.findAll();
    }
}
