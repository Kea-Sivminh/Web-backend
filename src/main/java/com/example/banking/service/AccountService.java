package com.example.banking.service;

import com.example.banking.entity.Account;
import com.example.banking.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    public Account updateAccount(Integer id, Account account) {
        Account existingsAccount = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingsAccount.setAccountName(account.getAccountName());
        existingsAccount.setBalance(account.getBalance());
        return accountRepository.save(existingsAccount);
    }

    public String deleteAccount(Integer id){
        Account exitedAccount = accountRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));

        accountRepository.delete(exitedAccount);
        return "Deleted succes";
    }

}
