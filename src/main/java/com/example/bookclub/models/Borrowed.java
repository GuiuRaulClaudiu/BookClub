package com.example.bookclub.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "borrowed")
public class Borrowed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrowed")
    @NonNull
    private Integer id_borrowed;

    @Column(name = "return_date")
    @NonNull
    private LocalDate return_date;

    @Column(name = "borrowed_date")
    @NonNull
    private LocalDate borrowed_date;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Account account;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private BookOwner bookOwner;
}
