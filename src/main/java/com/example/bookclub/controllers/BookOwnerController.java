package com.example.bookclub.controllers;

import com.example.bookclub.models.BookOwner;
import com.example.bookclub.services.AccountService;
import com.example.bookclub.services.BookOwnerService;
import com.example.bookclub.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book-owner")
public class BookOwnerController {
    @Autowired
    private BookOwnerService bookOwnerService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<BookOwner> getAll() {
        return bookOwnerService.getAll();
    }

    @GetMapping
    @RequestMapping("{id_book_owner}")
    public Object getById(@PathVariable Integer id_book_owner) {
        return bookOwnerService.getReferenceById(id_book_owner);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookOwner create(@RequestBody BookOwner bookOwner) {
        return bookOwnerService.saveAndFlush(bookOwner);
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @RequestMapping(value = "{id_acc}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id_acc) {
        bookOwnerService.deleteById(id_acc);
    }

    @RequestMapping(value = "{id_acc}", method = RequestMethod.PUT)
    public BookOwner update(@PathVariable Integer id_acc, @RequestBody BookOwnerController account) {
        BookOwner existingBookOwner = bookOwnerService.getReferenceById(id_acc);
        BeanUtils.copyProperties(account, existingBookOwner, "id_acc");
        return bookOwnerService.saveAndFlush(existingBookOwner);
    }

    @RequestMapping(value = "/account/{id_acc}")
    public Optional<BookOwner> getAllBookOwnersByAccountId(@PathVariable(value = "id_acc") Integer id_acc) {
        return bookOwnerService.findByAccountId(id_acc);
    }


}
