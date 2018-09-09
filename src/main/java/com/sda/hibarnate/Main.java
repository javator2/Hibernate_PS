package com.sda.hibarnate;

import com.sda.hibarnate.entity.Author;
import com.sda.hibarnate.entity.Book;
import com.sda.hibarnate.entity.Category;
import com.sda.hibarnate.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    static Session getSession(){
        return  sessionFactory.openSession();
    }

    public static void main(String[] args) {

        Session session = getSession();
        Transaction tx= session.getTransaction();

      //      List<Book> bookList = session.createQuery("FROM "+ Book.class.getName()).list();
      //  for(Book b: bookList){
      //      System.out.println(" "+b.getTitle());
      //   }
       // Book book2 =session.byId(Book.class).getReference(3);
        //System.out.println(book2);
       // tx.begin();
       // session.delete(book2);
       // tx.commit();

        tx.begin();
        Category category = new Category("Jakies");
        Publisher publisher = new Publisher("AbC","ul.Gdzies","Ziemia");
        Book book3 = new Book();
        book3.setTitle("XXXXXX");
        book3.setIsbn("111-111-1");
        book3.setAuthors(new HashSet<Author>
                (Arrays.asList(new Author("Jan","Nowak"),new Author("Marcin","Kowalski"))));
        book3.setCategory(category);
        book3.setPublisher(publisher);
        session.save(book3);
        tx.commit();

        List<Book> books =
                session.createQuery("From "+Book.class.getName()).list();

        for (Book b: books){
            System.out.println("Tytul: "+b.getTitle());

            for(Author a: b.getAuthors()){
                System.out.println("Autors: "+ a.getName()+" "+ a.getLastName());
            }
        }

        session.close();


    }
}