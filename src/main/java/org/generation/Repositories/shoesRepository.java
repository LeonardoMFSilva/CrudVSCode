package org.generation.Repositories;

import java.util.List;

import org.generation.Models.shoes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface shoesRepository extends JpaRepository<shoes, Long> {
    public List <shoes> findAllByShoeNameContainingIgnoreCase (String shoeName);
    public List <shoes> findAllBySize (int size);
    public List<shoes> findAllByShoeModelContainingIgnoreCase (String shoeModel);
    public List<shoes> findAllByLaunchYearContainingIgnoreCase (String launchYear);
}