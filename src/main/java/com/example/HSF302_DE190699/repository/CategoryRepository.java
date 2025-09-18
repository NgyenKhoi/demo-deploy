package com.example.HSF302_DE190699.repository;

import com.example.HSF302_DE190699.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}