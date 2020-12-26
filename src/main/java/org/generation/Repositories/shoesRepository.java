package org.generation.Repositories;

import java.util.List;

import org.generation.Models.shoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface shoesRepository extends JpaRepository<shoes, Long> {
    public List <shoes> findAllByNameContainingIgnoreCase (String shoeName);
    public List <shoes> findAllBySize (int size);
    public List<shoes> findAllByModelContainingIgnoreCase (String shoeModel);
    public List<shoes> findAllByYearContainingIgnoreCase (String launchYear);
}