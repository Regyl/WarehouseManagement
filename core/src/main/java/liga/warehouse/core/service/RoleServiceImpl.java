package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.repository.RoleRepository;
import liga.warehouse.coreapi.model.Role;
import liga.warehouse.coreapi.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException.supplierOf(Role.class, id));
    }

    @Override
    public void save(Role entity) {
        repository.save(entity);
    }

    @Override
    public Role deleteById(Long id) {
        Role role = findById(id);
        repository.deleteById(id);
        return role;
    }

    @Override
    public Role findByAuthority(String authority) {
        return repository.findByAuthority(authority)
                .orElseThrow(EntityNotFoundException.supplierOf(Role.class, authority));
    }

    @Override
    public Set<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Role entity) {
        repository.update(entity);
    }

    @Override
    public void saveAll(Set<Role> roles) {
        repository.saveAll(roles);
    }
}
