package com.example.bookclub.repositories;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BorrowedRepository extends JpaRepository<Borrowed, Integer> {

    @Query("SELECT b FROM Borrowed b \n" +
            "WHERE b.return_date <= :now")
    List<Borrowed> getAvailableForRenting(LocalDate now);
    @Query("SELECT b FROM Borrowed b \n" +
            "JOIN b.bookOwner o\n" +
            "ON b.bookOwner.id_book_owner = o.id_book_owner \n" +
            "WHERE o.account.id_acc = :id")
    List<Borrowed> getBorrowedBookByOthers(Integer id);

    @Query("SELECT b FROM Borrowed b\n" +
            "JOIN b.bookOwner o \n" +
            "JOIN o.book bk \n" +
            "WHERE bk.author = :search OR bk.title = :search")
    List<Borrowed> getTitleOrAuthor(String search);

    @Query("SELECT b FROM Borrowed  b\n" +
            "WHERE b.account.id_acc = :id_acc")
    List<Borrowed> getBorrowedByAccount_id(Integer id_acc);

}
