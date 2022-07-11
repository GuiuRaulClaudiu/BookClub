package com.example.bookclub.controllers;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.BookOwner;
import com.example.bookclub.services.BookOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-owner")
public class BookOwnerController {
    @Autowired
    private BookOwnerService bookOwnerService;

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
    public void create(@RequestParam Integer id_acc, @RequestParam Integer id_book) {
        bookOwnerService.saveAndFlush(id_acc,id_book);
    }

}
