package com.example.exam3.Controller;

import com.example.exam3.Model.Account;
import com.example.exam3.SERVICE.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    public ResponseEntity addAccount(Account account,Integer custpmerId) {
        accountService.addAccount(account,custpmerId);
        return ResponseEntity.status(200).body("account added successfully");

    }
    public ResponseEntity.
}
