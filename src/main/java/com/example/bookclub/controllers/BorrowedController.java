package com.example.bookclub.controllers;

import com.example.bookclub.models.Account;
import com.example.bookclub.models.Book;
import com.example.bookclub.models.Borrowed;
import com.example.bookclub.services.BorrowedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/borrowed")
public class BorrowedController {
    @Autowired
    private BorrowedService borrowedService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Borrowed> getAll(){
        return borrowedService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam Integer id_acc, @RequestParam Integer id_book,@RequestParam Integer borrow_period) {
        borrowedService.saveAndFlush(id_acc, id_book,borrow_period);
    }



    @RequestMapping(value = "/booksByOthers", method = RequestMethod.GET)
    public List<Borrowed> getBorrowedBookByOthers(@RequestParam(value = "id_acc") Integer id_acc){
        return borrowedService.getBorrowedBookByOthers(id_acc);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Borrowed> getBorrowedBooks(@RequestParam(value = "id_acc") Integer id_acc){
        return borrowedService.getBorrowedBooks(id_acc);
    }

    @RequestMapping(value = "/titleOrAuthor", method = RequestMethod.GET)
    public List<Borrowed> getTitleOrAuthor(@RequestParam(value = "search") String search){
        return borrowedService.getTitleOrAuthor(search);
    }

    @RequestMapping(value = "/extend", method = RequestMethod.PUT)
    public Borrowed extendPeriod(@RequestParam(value = "id_borrowed") Integer id_borrowed,@RequestParam(value = "extend") Integer extend){
        return borrowedService.extendPeriod(id_borrowed,extend);
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public List<Borrowed> getAvailableForRenting(){
        return borrowedService.getAvailableForRenting();
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    @RequestMapping(value = "{id_acc}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id_acc) {
        borrowedService.deleteById(id_acc);
    }

}
