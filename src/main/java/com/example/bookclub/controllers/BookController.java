package com.example.bookclub.controllers;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.Borrowed;
import com.example.bookclub.repositories.AccountRepository;
import com.example.bookclub.repositories.BookRepository;
import com.example.bookclub.services.AccountService;
import com.example.bookclub.services.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> list() {
        return bookService.getAll();
    }

    @GetMapping
    @RequestMapping("{id_book}")
    public Book get(@PathVariable Integer id_book) {
        return bookService.getReferenceById(id_book);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody final Book book) {
        return bookService.saveAndFlush(book);
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @RequestMapping(value = "{id_book}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id_book) {
        bookService.deleteById(id_book);
    }

    @RequestMapping(value = "{id_book}", method = RequestMethod.PUT)
    public Book update(@PathVariable Integer id_book, @RequestBody Book book) {
        Book existingBook = bookService.getReferenceById(id_book);
        BeanUtils.copyProperties(book, existingBook, "id_book");
        return bookService.saveAndFlush(existingBook);
    }


}
