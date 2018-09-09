package com.sda.hibarnate.entity;
import javax.persistence.*;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;
    @Column
    private String isbn;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Author> authors;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}