package com.example.HSF302_DE190699.service;

import com.example.HSF302_DE190699.entity.Product;
import com.example.HSF302_DE190699.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        if (product.getId() != null) {
            // Là update, load bản gốc từ DB
            Product existing = productRepository.findById(product.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
            product.setCreatedAt(existing.getCreatedAt()); // giữ nguyên
        } else {
            product.setCreatedAt(Instant.now());
        }

        product.setUpdatedAt(Instant.now());
        return productRepository.save(product);
    }


    public List<Product> listProduct() {
        return productRepository.findAll();
    }
}
