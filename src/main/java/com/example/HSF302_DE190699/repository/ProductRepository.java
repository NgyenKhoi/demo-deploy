package com.example.HSF302_DE190699.repository;

import com.example.HSF302_DE190699.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = """
        SELECT p.* FROM (
            SELECT *,
                   ROW_NUMBER() OVER (PARTITION BY cate_id ORDER BY stock DESC) AS rn
            FROM sony_products
        ) p
        WHERE p.rn <= 5
        ORDER BY p.cate_id, p.stock DESC
        """, nativeQuery = true)
    List<Product> findTop5ProductsByStockPerCategory();
}