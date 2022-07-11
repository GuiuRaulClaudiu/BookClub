package com.example.bookclub.services;

import com.example.bookclub.models.Account;
import com.example.bookclub.repositories.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account getReferenceById(Integer id_acc) {
        return accountRepository.getReferenceById(id_acc);
    }

    public Account saveAndFlush(Account account){
        return accountRepository.saveAndFlush(account);
    }
    public Account saveAndFlush(Integer id_acc,Account account) {
        Account existingAccount = accountRepository.getReferenceById(id_acc);
        BeanUtils.copyProperties(account, existingAccount, "id_acc");
        return accountRepository.saveAndFlush(account);
    }

    public void deleteById(Integer id_acc) {
        accountRepository.deleteById(id_acc);
    }

    public Account getAccountByNameOrEmail(String name, String email) {
        return accountRepository.getAccountByNameOrEmail(name,email);
    }
}
