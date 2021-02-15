package com.akashneil.spring.jpa.h2.controller;

import com.akashneil.spring.jpa.h2.model.Book;
import com.akashneil.spring.jpa.h2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        try {

            List<Book> books = new ArrayList<Book>(bookRepository.findAll());

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/booksByName")
    public ResponseEntity<List<Book>> getBooksByName(@RequestParam(name="name", required = true) String name) {

        try {

            List<Book> books = new ArrayList<Book>(bookRepository.findBookByName(name));
            return new ResponseEntity<>(books, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "/createNewBook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Book> createBook(@RequestBody final Book book) {

        try {

            bookRepository.save(book);
            return new ResponseEntity<>(book, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/updateBook")
    public ResponseEntity<Book> updateBook(@RequestParam(name="id", required = true) int id,
                                           @RequestBody final Book book) {
        try {

            Optional<Book> bookData = bookRepository.findById(id);

            if (bookData.isPresent()) {
                Book _book = bookData.get();
                if (book.getName() != null) { _book.setName(book.getName()); }
                if (book.getAuthor() != null) { _book.setName(book.getAuthor()); }
                if (book.getFormat() != null) { _book.setName(book.getFormat()); }

                bookRepository.save(_book);

                return new ResponseEntity<>(_book, HttpStatus.OK);

            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }


        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteBook")
    public ResponseEntity<Book> deleteBook(@RequestParam(name="id", required = true) int id){
        try {

            Optional<Book> bookToDelete = bookRepository.findById(id);
            bookToDelete.ifPresent(book -> bookRepository.delete(book));
            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
