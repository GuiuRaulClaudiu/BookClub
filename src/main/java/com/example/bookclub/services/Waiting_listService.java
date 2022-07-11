package com.example.bookclub.services;

import com.example.bookclub.models.Waiting_list;
import com.example.bookclub.repositories.AccountRepository;
import com.example.bookclub.repositories.BookOwnerRepository;
import com.example.bookclub.repositories.Waiting_listRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Waiting_listService {
    @Autowired
    private Waiting_listRepository waiting_listRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    public List<Waiting_list> getAll() {
        return waiting_listRepository.findAll();
    }

    public void saveAndFlush(Integer id_acc, Integer id_book) {
        Waiting_list waiting_list = new Waiting_list();
        waiting_list.setAccount(accountRepository.findById(id_acc).get());
        waiting_list.setBookOwner(bookOwnerRepository.findByBookId(id_book));
        waiting_listRepository.saveAndFlush(waiting_list);
    }
}
