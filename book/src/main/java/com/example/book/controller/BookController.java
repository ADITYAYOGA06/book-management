package com.example.book.controller;

import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        List<Book> list = bookRepository.findAll();
        return list;
    }

    @GetMapping("/books/id")
    public Optional<Book> findById(@RequestParam String idBuku) {
        return bookRepository.findById(idBuku);
    }

    @PostMapping("/books")
    public String saveTxn(@RequestBody Book book) {
        bookRepository.save(book);
        return "BOOK SAVED";
    }

    @DeleteMapping("/books/id")
    public String deletePny(@RequestParam String idBuku) {
        bookRepository.deleteById(String.valueOf(idBuku));
        return "BOOK DELETE SUCCESS";
    }

    @PutMapping("/books/id")
    public ResponseEntity<String> updateUserById(@RequestParam String idBuku, @RequestParam String judul, @RequestParam String penulis, @RequestParam String penerbit) {

        Optional<Book> optionalBook = bookRepository.findById(idBuku);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setJudul(judul);
            book.setPenulis(penulis);
            book.setPenerbit(penerbit);
            bookRepository.save(book);
            return ResponseEntity.ok("Book information updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with ID: " + idBuku);
        }
    }
}