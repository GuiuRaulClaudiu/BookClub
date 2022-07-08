package com.example.bookclub.controllers;

import com.example.bookclub.models.Book;
import com.example.bookclub.repositories.AccountRepository;
import com.example.bookclub.repositories.BookRepository;
import com.example.bookclub.services.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id_book}")
    public Optional<Book> get(@PathVariable Integer id_book) {
        return bookRepository.findById(id_book);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody final Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @RequestMapping(value = "{id_book}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id_book) {
        bookRepository.deleteById(id_book);
    }

    @RequestMapping(value = "{id_book}", method = RequestMethod.PUT)
    public Book update(@PathVariable Integer id_book, @RequestBody Book book) {
        Book existingBook = bookRepository.getReferenceById(id_book);
        BeanUtils.copyProperties(book, existingBook, "id_book");
        return bookRepository.saveAndFlush(existingBook);
    }
}
