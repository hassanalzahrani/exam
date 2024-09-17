package com.example.exam3.REPOSITORY;

import com.example.exam3.Model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostumerRepository extends JpaRepository<Costumer,Integer> {

    Costumer findCostumerById(Integer id);
}
