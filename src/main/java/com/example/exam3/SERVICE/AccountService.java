package com.example.exam3.SERVICE;

import com.example.exam3.ApiException;
import com.example.exam3.Model.Account;
import com.example.exam3.Model.Costumer;
import com.example.exam3.Model.User;
import com.example.exam3.REPOSITORY.AccountRepository;
import com.example.exam3.REPOSITORY.AuthRepostory;
import com.example.exam3.REPOSITORY.CostumerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AuthRepostory authRepostory;
    private final CostumerRepository costumerRepository;
    private final DefaultAuthenticationEventPublisher authenticationEventPublisher;


    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

 public void addAccount(Account account,Integer customerId){
     Costumer costumer=costumerRepository.findCostumerById(customerId);
if(costumer==null){
    throw new ApiException("Costumer not found");
}

 }


 public void updateAccount(Account account,Integer customerId,Integer accountId){
        Costumer costumer=costumerRepository.findCostumerById(customerId);
        if(costumer==null){
            throw new ApiException("Costumer not found");
        }
   Account account1=accountRepository.findAccountById(accountId);
        if(account1==null){
            throw new ApiException("Account not found");
        }
     if (account1.getId()!=account.getCostumers().getId()){
         throw new ApiException("Costumer id mismatch");
     }
        account1.setAccountNumber(account.getAccountNumber());
        account1.setBalance(account.getBalance());
        account1.setAvtive(account.isAvtive());
        accountRepository.save(account);

 }

 public void deleteAccount(Integer accountId,Integer customerId){
        Account account=accountRepository.findAccountById(accountId);
        if(account==null){
            throw new ApiException("Account not found");
        }
        Costumer costumer=costumerRepository.findCostumerById(customerId);
        if(costumer==null){
            throw new ApiException("Costumer not found");
        }


 }





    public void deposit(int accountId, double amount,int userId) {

        Account account=accountRepository.findAccountById(accountId);
        if (account==null) {
     throw new ApiException("Account not found");
        }
        User user=authRepostory.findById(userId);
        if (user==null) {
            throw new ApiException("User not found");
        }
        if (account.getCostumers().getId()!=user.getId()){
            throw new ApiException("Account has different costumers");
        }
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
    }

    public void withdraw(int accountId, double amount,int userId) {
        Account account=accountRepository.findAccountById(accountId);
        if (account==null) {
            throw new ApiException("Account not found");
        }
        User user=authRepostory.findById(userId);
        if (user==null) {
            throw new ApiException("User not found");
        }
        if (account.getCostumers().getId()!=user.getId()){
            throw new ApiException("Account has different costumers");
        }
        if (account.getBalance()<amount){
            throw new ApiException("you dont have enough money");
        }
        account.setBalance(account.getBalance()- amount);
        accountRepository.save(account);
    }
   public void transfer(int fromAccountId, int toAccountId, double amount,int userId) {
        Account fromAccount=accountRepository.findAccountById(fromAccountId);
        Account toAccount=accountRepository.findAccountById(toAccountId);
        User user=authRepostory.findById(userId);
        if (user==null) {
            throw new ApiException("User not found");
        }
        if (fromAccount==null) {
            throw new ApiException("Account not found");
        }
        if (toAccount==null) {
            throw new ApiException("Account not found");
        }
        if (fromAccount.getCostumers().getId()!=user.getId()){
            throw new ApiException("Account has different costumers");
        }
        if (toAccount.getCostumers().getId()!=user.getId()){
            throw new ApiException("Account has different costumers");
        }
        if (fromAccount.getBalance()<amount){
            throw new ApiException("you dont have enough money");
        }
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        accountRepository.save(fromAccount);
        toAccount.setBalance(toAccount.getBalance()+amount);
        accountRepository.save(toAccount);

   }

   }


