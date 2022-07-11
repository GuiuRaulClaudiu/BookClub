package com.example.bookclub.repositories;

import com.example.bookclub.models.Waiting_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Waiting_listRepository extends JpaRepository<Waiting_list,Integer> {
}
