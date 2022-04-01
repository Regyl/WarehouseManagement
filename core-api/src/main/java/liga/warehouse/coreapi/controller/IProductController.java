package liga.warehouse.coreapi.controller;

import liga.warehouse.dto.request.ProductDto;
import liga.warehouse.dto.request.SaleDto;
import liga.warehouse.dto.response.ProductDtoResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IProductController extends CrudController<ProductDto, ProductDtoResponse> {

    @PutMapping("/sales")
    void saleProduct(@RequestBody @Valid SaleDto dto);
}
