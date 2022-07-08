package com.example.bookclub.services;

import com.example.bookclub.models.Account;
import com.example.bookclub.models.Book;
import com.example.bookclub.models.BookOwner;
import com.example.bookclub.repositories.AccountRepository;
import com.example.bookclub.repositories.BookOwnerRepository;
import com.example.bookclub.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookOwnerService {
    @Autowired
    private BookOwnerRepository bookOwnerRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AccountRepository accountRepository;

    public BookOwnerService(BookOwnerRepository bookOwnerService, BookRepository bookRepository, AccountRepository accountRepository) {
        this.bookOwnerRepository = bookOwnerService;
        this.bookRepository = bookRepository;
        this.accountRepository = accountRepository;
    }

    public List<BookOwner> getAll() {
        return bookOwnerRepository.findAll();
    }

    public BookOwner getReferenceById(Integer id_book_owner) {
        return bookOwnerRepository.getReferenceById(id_book_owner);
    }
    @Transactional
    public BookOwner saveAndFlush(BookOwner bookOwner) {
        return bookOwnerRepository.save(bookOwner);
    }

    public void deleteById(Integer id_book_owner) {
        bookOwnerRepository.deleteById(id_book_owner);
    }

    public Optional<BookOwner> findByAccountId(Integer id_acc) {
        return bookOwnerRepository.findById(id_acc);
    }
}
