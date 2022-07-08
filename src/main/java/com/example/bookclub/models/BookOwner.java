package com.example.bookclub.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
@Getter
@Setter
@Entity(name = "book_owners")
public class BookOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book_owner")
    @NonNull
    private Integer id_book_owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_owner",referencedColumnName = "id_acc")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book",referencedColumnName = "id_book")
    private Book book;

}