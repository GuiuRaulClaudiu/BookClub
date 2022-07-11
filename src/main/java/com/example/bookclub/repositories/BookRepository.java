package com.example.bookclub.repositories;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {



}
