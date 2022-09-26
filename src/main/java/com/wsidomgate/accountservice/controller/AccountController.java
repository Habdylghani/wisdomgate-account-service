package com.wsidomgate.accountservice.controller;

import com.wsidomgate.accountservice.model.Account;
import com.wsidomgate.accountservice.exception.UserNotFoundException;
import com.wsidomgate.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-service")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        List<Account> accountList = accountService.getAllAccount();
        if (accountList == null) {
            throw new UserNotFoundException("No account in the list");
        }
        return accountList;
    }

    @GetMapping("/getAccount/{id}")
    public Account getAccountById(@PathVariable String id) {
        Account account = accountService.findAccount(id);
        if (account == null) {
            throw new UserNotFoundException("No account");
        }
        return account;
    }

    @PostMapping("/AddAccount")
    public void addAccount(@RequestBody Account account){
        try {
            accountService.addAccount(account);
        } catch (Exception e) {
            throw new UserNotFoundException("Error to add "+account);
        }
    }

    @DeleteMapping("/deleteAccount/{id}")
    public void deleteAccountById(@PathVariable String id) {
        Account account = accountService.deleteAccount(id);
        if (account == null) {
            throw new UserNotFoundException("No account to delete");
        }
    }
    @PutMapping("/updateAccount/{id}")
    public void updateAccount(@RequestBody Account account, @PathVariable String id) {
        try {
            accountService.updateAccount(account,id);
        } catch (Exception e) {
            throw new UserNotFoundException("Error to update account : "+id+" by "+account);
        }
    }
//    @GetMapping("/getAllHighRatedAccount")
//    public List<Account> getAllHighRatedAccount() {
//        List<Account> accountList = accountService.getAllTheHighRatedAccount();
//        if (accountList == null) {
//            throw new UserNotFoundException("No account in the list");
//        }
//        return accountList;
//    }

}
