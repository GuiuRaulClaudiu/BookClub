package com.example.bookclub.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "waiting_lists")
public class Waiting_list {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_waiting_list")
    @NonNull
    private Integer id_waiting_list;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private Account account;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    private BookOwner bookOwner;
}
