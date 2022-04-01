package liga.warehouse.core.controller.rest;

import liga.warehouse.core.controller.mapper.ProductMapper;
import liga.warehouse.coreapi.controller.CrudController;
import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.service.ProductService;
import liga.warehouse.dto.request.ProductDto;
import liga.warehouse.dto.response.ProductDtoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController implements CrudController<ProductDto, ProductDtoResponse> {

    private final ProductService service;
    private final ProductMapper mapper;

    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public Set<ProductDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public ProductDtoResponse findById(Long id) {
        Product product = service.findById(id);
        return mapper.toDto(product);
    }

    @Override
    public void save(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        service.save(product);
    }
}
