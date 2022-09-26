package com.wsidomgate.accountservice.service;

import com.wsidomgate.accountservice.model.Account;
import com.wsidomgate.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account addAccount(Account account) {
        return repository.save(account);
    }

    public Account findAccount(String id) {
        Optional<Account> account = repository.findById(id);
        return account.orElse(null);
    }

    public List<Account> getAllAccount() {
        return repository.findAll();
    }

    public Account updateAccount(Account account,String id) {
        Account updateAccount = findAccount(id);
        updateAccount.setFirstName(account.getFirstName());
        updateAccount.setLastName(account.getLastName());
        updateAccount.setUsername(account.getUsername());
        updateAccount.setPassword(account.getPassword());
        updateAccount.setEmail(account.getEmail());
        return repository.save(updateAccount);
    }

    public Account deleteAccount(String id) {
        Account account = findAccount(id);
        repository.delete(account);
        return account;
    }

    public void resetPassword(String id){
        Account account=findAccount(id);
        account.setPassword("");
    }

//    public List<Account> getAllTheHighRatedAccount(){
//        List<Account> accountList= repository.findTheHighRatedAccount();
//        return accountList;
//    }
}
