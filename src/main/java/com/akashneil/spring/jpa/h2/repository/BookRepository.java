package com.akashneil.spring.jpa.h2.repository;

import com.akashneil.spring.jpa.h2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContaining(String name);

    @Query("SELECT b FROM Book b WHERE b.name = :name")
    List<Book> findBookByName(@Param("name") String name);

    @Query("SELECT b FROM Book b WHERE b.author = :author")
    List<Book> findBookByAuthor(@Param("author") String author);

    @Query("SELECT b FROM Book b WHERE b.id = :id")
    Optional<Book> findById(@Param("id") int id);

}
