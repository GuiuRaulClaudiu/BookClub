package com.example.bookclub.controllers;

import com.example.bookclub.models.BookOwner;
import com.example.bookclub.models.Waiting_list;
import com.example.bookclub.services.Waiting_listService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/waiting_list")
public class Waiting_listController {
    @Autowired
    private Waiting_listService waiting_listService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Waiting_list> getAll() {
        return waiting_listService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestParam Integer id_acc, @RequestParam Integer id_book) {
        waiting_listService.saveAndFlush(id_acc,id_book);
    }
}
