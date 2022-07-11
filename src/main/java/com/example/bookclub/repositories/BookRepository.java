package com.example.bookclub.repositories;

import com.example.bookclub.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT b.bookOwner.book FROM Borrowed b \n" +
            "WHERE b.return_date <= :now")
    List<Book> getAvailableForRenting(LocalDate now);
}
