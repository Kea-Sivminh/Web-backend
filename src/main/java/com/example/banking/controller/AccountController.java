package com.example.banking.controller;

import com.example.banking.entity.Account;
import com.example.banking.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Account> findById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Integer id,@RequestBody Account account){
        return accountService.updateAccount(id, account);
    }
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Integer id){
        return accountService.deleteAccount(id);
    }
}