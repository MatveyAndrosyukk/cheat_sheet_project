package project_structure.product_service.service;

import project_structure.product_service.dto.ProductRequest;
import project_structure.product_service.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> findAll();
}
