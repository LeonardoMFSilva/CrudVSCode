package org.generation.Repositories;

import java.util.List;

import org.generation.Models.brands;

import org.springframework.data.jpa.repository.JpaRepository;

public interface brandsRepository extends JpaRepository <brands, Long> {
    public List<brands> findAllByBrandContainingIgnoreCase (String brandName);
}