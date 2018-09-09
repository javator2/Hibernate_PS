package com.sda.hibarnate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(length = 50, nullable = false, unique=true)
    private String name;

    @NonNull
    @Column(length = 50, nullable = false, unique=true)
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> bookSet;
}
