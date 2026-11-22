package com.example.banking.service;

import com.example.banking.entity.Account;
import com.example.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepositiry;
    public AccountService(AccountRepository accountRepository){
        this.accountRepositiry = accountRepository;
    }
    public Account createAccount(Account account){
        return accountRepositiry.save(account);
    }
    public List<Account>getAll(){
        return accountRepositiry.findAll();
    }
}
