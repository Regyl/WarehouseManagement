package liga.warehouse.core.service;

import liga.warehouse.core.exception.EntityNotFoundException;
import liga.warehouse.core.repository.UserRepository;
import liga.warehouse.coreapi.model.User;
import liga.warehouse.coreapi.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException.supplierOf(User.class, id));
    }

    @Override
    @Transactional
    public void save(User entity) {
        try {
            loadUserByUsername(entity.getUsername());
        } catch (UsernameNotFoundException e) {
            repository.save(entity);
            repository.saveRoles(entity.getId(), entity.getRoles());
        }
    }

    @Override
    public User deleteById(Long id) {
        User user = findById(id);
        repository.deleteById(id);
        return user;
    }

    @Override
    public Set<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(User entity) {
        repository.update(entity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
