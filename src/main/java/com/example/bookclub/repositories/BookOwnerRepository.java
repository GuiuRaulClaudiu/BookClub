package com.example.bookclub.repositories;

import com.example.bookclub.models.BookOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOwnerRepository extends JpaRepository<BookOwner,Integer> {
}
