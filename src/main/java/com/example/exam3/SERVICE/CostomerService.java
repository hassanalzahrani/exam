package com.example.exam3.SERVICE;

import com.example.exam3.ApiException;
import com.example.exam3.DTO.CustomerDTO;
import com.example.exam3.Model.Costumer;
import com.example.exam3.REPOSITORY.AuthRepostory;
import com.example.exam3.REPOSITORY.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CostomerService {
    private final CostumerRepository costumerRepository;
    private final AuthRepostory authRepostory;

    public List<Costumer> findAll() {
        return costumerRepository.findAll();
    }



    public void delete(Integer costumerId) {
        costumerRepository.deleteById(costumerId);
    }
    public void update(Costumer costumer, Integer costumerId) {
        Costumer oldCostumer = costumerRepository.findCostumerById(costumerId);
        if (oldCostumer == null) {
            throw new ApiException("Costumer not found");
        }
        if (costumer.getId() != oldCostumer.getId()) {
            throw new ApiException("Costumer id mismatch");
        }
   oldCostumer.setPhoneNumber(costumer.getPhoneNumber());
        costumerRepository.save(oldCostumer);
    }



}

