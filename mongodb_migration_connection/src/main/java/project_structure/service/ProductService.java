package project_structure.service;



import project_structure.dto.ProductRequest;
import project_structure.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> findAll();
    ProductResponse findById(String id);

    ProductResponse findByName(String name);
    ProductResponse save(ProductRequest productRequest);
    String deleteById(String id);


}
