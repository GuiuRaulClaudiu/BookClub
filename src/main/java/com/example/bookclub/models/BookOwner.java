package com.example.bookclub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "book_owners")
public class BookOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_owner")
    @NonNull
    private Integer id_book_owner;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Account account;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Book book;

    @JsonIgnore
    @OneToMany(mappedBy = "bookOwner")
    private List<Borrowed> borrowedList;


}