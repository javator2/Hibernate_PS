package com.sda.hibarnate.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(length = 50, nullable = false, unique=true)
    private String name;

    @NonNull
    @Column(length = 50, nullable = false, unique=true)
    private String adress;

    @NonNull
    @Column(length = 50, nullable = false, unique=true)
    private String city;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> bookSet;


}
