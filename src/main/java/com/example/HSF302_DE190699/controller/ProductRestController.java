package com.example.HSF302_DE190699.controller;

import com.example.HSF302_DE190699.entity.Category;
import com.example.HSF302_DE190699.entity.Product;
import com.example.HSF302_DE190699.repository.CategoryRepository;
import com.example.HSF302_DE190699.repository.ProductRepository;
import com.example.HSF302_DE190699.service.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductRestController(ProductService productService, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    // Lấy tất cả sản phẩm
    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        return ResponseEntity.ok(productService.listProduct());
    }

    // Thêm sản phẩm
    @PostMapping
    @Transactional
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
            product.setCategory(category);
        }
        Product saved = productService.save(product);
        return ResponseEntity.ok(saved);
    }

    // Sửa sản phẩm
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> editProduct(@PathVariable Integer id, @Valid @RequestBody Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        existing.setProductName(product.getProductName());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());

        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryRepository.findById(product.getCategory().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid category ID"));
            existing.setCategory(category);
        }

        Product updated = productRepository.save(existing);
        return ResponseEntity.ok(updated);
    }

    // Xoá sản phẩm
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Top 5 sản phẩm theo category
    @GetMapping("/top5-by-category")
    public ResponseEntity<List<Product>> showTop5ProductsByCategory() {
        return ResponseEntity.ok(productRepository.findTop5ProductsByStockPerCategory());
    }
}
