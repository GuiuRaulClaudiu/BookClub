package com.example.bookclub.controllers;

import com.example.bookclub.models.Account;
import com.example.bookclub.services.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping
    @RequestMapping("{id_acc}")
    public Account getById(@PathVariable Integer id_acc) {
        return accountService.getReferenceById(id_acc);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody final Account account) {
        return accountService.saveAndFlush(account);
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @RequestMapping(value = "{id_acc}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id_acc) {
        accountService.deleteById(id_acc);
    }

    @RequestMapping(value = "{id_acc}", method = RequestMethod.PUT)
    public Account update(@PathVariable Integer id_acc, @RequestBody Account account) {
        return accountService.saveAndFlush(id_acc,account);
    }

}
