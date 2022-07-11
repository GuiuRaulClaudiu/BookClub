package com.example.bookclub.services;

import com.example.bookclub.models.Borrowed;
import com.example.bookclub.repositories.AccountRepository;
import com.example.bookclub.repositories.BookOwnerRepository;
import com.example.bookclub.repositories.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowedService {
    @Autowired
    private BorrowedRepository borrowedRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BookOwnerRepository bookOwnerRepository;

    public List<Borrowed> getAll() {
        return borrowedRepository.findAll();
    }

    public void saveAndFlush(Integer id_acc, Integer id_book, Integer borrow_period) {
        Borrowed borrowed = new Borrowed();
        borrowed.setAccount(accountRepository.findById(id_acc).get());
        borrowed.setBookOwner(bookOwnerRepository.findByBookId(id_book));
        borrowed.setBorrowed_date(LocalDate.now());
        borrowed.setReturn_date(LocalDate.now().plusWeeks(borrow_period));
        borrowedRepository.saveAndFlush(borrowed);
    }

    public List<Borrowed> getAvailableForRenting() {
        return borrowedRepository.getAvailableForRenting(LocalDate.now());
    }

    public List<Borrowed> getBorrowedBookByOthers(Integer id_acc) {
        return borrowedRepository.getBorrowedBookByOthers(id_acc);
    }


    public Borrowed getReferenceById(Integer id_acc) {
        return borrowedRepository.getReferenceById(id_acc);
    }

    public Borrowed extendPeriod(Integer id_borrowed, Integer extend) {
        Borrowed existingBorrowed = borrowedRepository.getReferenceById(id_borrowed);
        LocalDate localDate = existingBorrowed.getReturn_date();
        existingBorrowed.setReturn_date(localDate.plusWeeks(extend));
        return borrowedRepository.saveAndFlush(existingBorrowed);
    }

    public List<Borrowed> getBorrowedBooks(Integer id_acc) {
        return borrowedRepository.getBorrowedByAccount_id(id_acc);
    }

    public void deleteById(Integer id_acc) {
        borrowedRepository.deleteById(id_acc);
    }

    public List<Borrowed> getTitleOrAuthor(String search) {
        return borrowedRepository.getTitleOrAuthor(search);
    }
}
