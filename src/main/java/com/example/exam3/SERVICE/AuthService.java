package com.example.exam3.SERVICE;

import com.example.exam3.REPOSITORY.AuthRepostory;
import com.example.exam3.REPOSITORY.CostumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final AuthRepostory authRepository;
    private final CostumerRepository customerRepository;

    public List<User> getAllUsers() {
        return authRepository.findAll();
    }

}

