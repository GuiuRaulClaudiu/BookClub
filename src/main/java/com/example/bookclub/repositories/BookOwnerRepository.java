package com.example.bookclub.repositories;

import com.example.bookclub.models.BookOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookOwnerRepository extends JpaRepository<BookOwner,Integer> {
    @Query("SELECT a FROM book_owners a \n" +
            "WHERE a.book.id_book = :id")
    BookOwner findByBookId(Integer id);
}
