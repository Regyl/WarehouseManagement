package liga.warehouse.core.controller.rest;

import liga.warehouse.core.controller.mapper.ProductMapper;
import liga.warehouse.core.controller.mapper.SaleMapper;
import liga.warehouse.coreapi.controller.IProductController;
import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.model.Sale;
import liga.warehouse.coreapi.service.ProductService;
import liga.warehouse.dto.request.ProductDto;
import liga.warehouse.dto.request.SaleDto;
import liga.warehouse.dto.response.ProductDtoResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController implements IProductController {

    private final ProductService service;
    private final ProductMapper mapper;
    private final SaleMapper saleMapper;

    public ProductController(ProductService service,
                             ProductMapper mapper, SaleMapper saleMapper) {
        this.service = service;
        this.mapper = mapper;
        this.saleMapper = saleMapper;
    }

    @Override
    public void saleProduct(SaleDto dto) {
        Sale sale = saleMapper.toEntity(dto);
        service.sale(sale);
    }

    @Override
    public void updateById(Long id, ProductDto dto) {
        Product product = service.findById(id);
        mapper.update(dto, product);
        service.update(product);
    }

    @Override
    public ProductDtoResponse deleteById(Long id) {
        Product product = service.deleteById(id);
        return mapper.toDto(product);
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
