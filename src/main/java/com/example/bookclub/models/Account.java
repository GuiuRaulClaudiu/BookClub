package com.example.bookclub.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity()
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acc")
    private Integer id_acc;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NonNull
    private String password;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<BookOwner> bookOwnersList;

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Borrowed> borrowedList;

}
