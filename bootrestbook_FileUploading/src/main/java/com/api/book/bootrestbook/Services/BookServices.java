package com.api.book.bootrestbook.Services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.Dao.BookRepository;
import com.api.book.bootrestbook.Entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServices {
	@Autowired
    private BookRepository bookRepository;
//     private static List<Book> lists = new ArrayList<>();
//     static {
//          lists.add(new Book(12, "Spring Boot", "XYZ"));
//          lists.add(new Book(13, "Spring ", "ABC"));
//         lists.add(new Book(14, "JAVA", "PQR"));
//         }

     // All Books
    public List<Book> getAllBooks() {
        // return lists;
        return (List<Book>) this.bookRepository.findAll();
    }
    // Single book
    public Book getBookByID(int id) {
        Book book = null;
        try {
           //book = lists.stream().filter(e -> e.getId() == id).findFirst().get();
            book = bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;

    }
    //Adding Book
    public Book  addBook(Book book) {
//	         lists.add(book);
//	         return book;
        Book res = bookRepository.save(book);
         return res;
    }

     // Delete
     public void deleteBook(int bId) {
//          lists = lists.stream().filter(e -> e.getId() != bId)
//         .collect(Collectors.toList());

        bookRepository.deleteById(bId);
    }

       // Update
       public void updateBook(Book book, int bookid) {
//        lists = lists.stream().map(b -> {
//         if (b.getId() == bookid) {
//         b.setAuthor(book.getAuthor());
//         b.setTitle(book.getTitle());
//         }
//         return b;
//        }).collect(Collectors.toList());
         book.setId(bookid);
         bookRepository.save(book);
    }
}
