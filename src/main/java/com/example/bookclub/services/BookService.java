package com.example.bookclub.services;

import com.example.bookclub.models.Account;
import com.example.bookclub.models.Book;
import com.example.bookclub.models.BookOwner;
import com.example.bookclub.models.Borrowed;
import com.example.bookclub.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getReferenceById(Integer id_book) {
        return bookRepository.getReferenceById(id_book);
    }

    public Book saveAndFlush(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public void deleteById(Integer id_book) {
        bookRepository.deleteById(id_book);
    }

    public List<Book> getAvailableForRenting() {
        BookRepository bookRepository1 = bookRepository;
        List<Book> bookList = new java.util.ArrayList<>(bookRepository1.findAll().stream().filter(b
                -> b.getBookOwnersList().isEmpty()).toList());
        bookList.addAll(bookRepository.getAvailableForRenting(LocalDate.now()));
        return bookList;
    }
}
