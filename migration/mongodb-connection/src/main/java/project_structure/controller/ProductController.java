package project_structure.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project_structure.dto.ProductRequest;
import project_structure.dto.ProductResponse;
import project_structure.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductResponse>> handleGetAllProducts(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductResponse> handleSaveProduct(@RequestBody ProductRequest productRequest){
        ProductResponse response = productService.save(productRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
