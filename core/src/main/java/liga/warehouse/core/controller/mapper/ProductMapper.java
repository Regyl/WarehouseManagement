package liga.warehouse.core.controller.mapper;

import liga.warehouse.coreapi.model.Nomenclature;
import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.service.NomenclatureService;
import liga.warehouse.dto.request.ProductDto;
import liga.warehouse.dto.response.ProductDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractMapper<Product, ProductDto> {

    private final NomenclatureService nomenclatureService;

    public ProductMapper(ModelMapper mapper, NomenclatureService nomenclatureService) {
        super(mapper);
        this.nomenclatureService = nomenclatureService;
    }

    @Override
    public Product toEntity(ProductDto dto) {
        Product product = mapper.map(dto, Product.class);
        Nomenclature nomenclature = nomenclatureService.findById(dto.getNomenclatureId());
        product.setNomenclature(nomenclature);
        return product;
    }

    @Override
    public ProductDtoResponse toDto(Product entity) {
        return mapper.map(entity, ProductDtoResponse.class);
    }

    @Override
    public void update(ProductDto source, Product destination) {
        mapper.map(source, destination);
    }
}
