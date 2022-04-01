package liga.warehouse.coreapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.Set;

public interface CrudController<T, S> {

    @DeleteMapping("/{id}")
    S deleteById(@PathVariable Long id);

    @GetMapping("/")
    Set<S> findAll();

    @GetMapping("/{id}")
    S findById(@PathVariable Long id);

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody @Valid T dto);

    @PatchMapping("/{id}")
    void updateById(@PathVariable Long id, @RequestBody @Valid T dto);

}
