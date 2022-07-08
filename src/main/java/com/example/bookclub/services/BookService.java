package com.example.bookclub.services;

import com.example.bookclub.models.Account;
import com.example.bookclub.models.Book;
import com.example.bookclub.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

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
}
