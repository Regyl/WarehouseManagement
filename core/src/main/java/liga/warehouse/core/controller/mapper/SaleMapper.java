package liga.warehouse.core.controller.mapper;

import liga.warehouse.coreapi.model.Product;
import liga.warehouse.coreapi.model.Sale;
import liga.warehouse.coreapi.service.ProductService;
import liga.warehouse.dto.request.SaleDto;
import liga.warehouse.dto.response.AbstractDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SaleMapper extends AbstractMapper<Sale, SaleDto> {

    private final ProductService productService;

    public SaleMapper(ModelMapper mapper, ProductService productService) {
        super(mapper);
        this.productService = productService;
    }

    @Override
    public Sale toEntity(SaleDto dto) {
        Product product = productService.findById(dto.getProductId());
        Sale sale = mapper.map(dto, Sale.class);
        sale.setProduct(product);
        float sum = (float) (sale.getQuantity() * product.getCost());
        sale.setSum(sum);
        return sale;
    }

    @Override
    public AbstractDtoResponse toDto(Sale entity) {
        throw new UnsupportedOperationException();
    }
}
