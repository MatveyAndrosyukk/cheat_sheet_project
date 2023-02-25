package project_structure.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project_structure.dto.ProductRequest;
import project_structure.dto.ProductResponse;
import project_structure.model.Product;
import project_structure.repository.ProductRepository;
import project_structure.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    @Override
    public ProductResponse findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product does not exists"));
        return mapToProductResponse(product);
    }

    @Override
    public ProductResponse findByName(String name) {
        Product product = productRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Product does not exists"));

        return mapToProductResponse(product);
    }

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }

    @Override
    public String deleteById(String id) {
        productRepository.deleteById(id);
        return id;
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
