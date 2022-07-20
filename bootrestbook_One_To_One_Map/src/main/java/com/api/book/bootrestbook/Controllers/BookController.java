package com.api.book.bootrestbook.Controllers;


import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.Services.BookServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookServices bookServices; 

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = bookServices.getAllBooks();

        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getSingleBookById(@PathVariable("id") int id) {
        Book book = bookServices.getBookByID(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.of(Optional.of(book));
        }
    }
    // Create books
    @PostMapping("/books")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = bookServices.addBook(book);
            // return ResponseEntity.status(HttpStatus.CREATED).build();
            return ResponseEntity.of(Optional.of(b));
             

        } catch (Exception e) {
            e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

     // Delete Book
     @DeleteMapping("/books/{bid}")
     public ResponseEntity<String> deleteBook(@PathVariable("bid") int bookid) {
        try {
            bookServices.deleteBook(bookid);
            //return ResponseEntity.ok().build();
            return new  ResponseEntity<>("Deleted Successfully",HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		
    }

     //update
     @PutMapping("/books/{bid}")
     public ResponseEntity<Book> updateBook(@RequestBody Book b, @PathVariable("bid") int id) {
        try {
            bookServices.updateBook(b, id);
            return ResponseEntity.ok().body(b);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
