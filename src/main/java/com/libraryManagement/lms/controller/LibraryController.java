package com.libraryManagement.lms.controller;

import com.libraryManagement.lms.model.Book;
import com.libraryManagement.lms.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return libraryService.getAllBooks();
    }

    @PostMapping("/books")
    public String addBook(@RequestBody Book book){
        libraryService.addBook(book);
        return "Book added to Library Successfully!!";
    }

    @PutMapping("/books/{id}/borrow")
    public String borrowBook(@PathVariable String id){
        boolean success = libraryService.borrowBook(id);
        return success? "Book borrowed successfully" : "Book not available sorry!!";
    }
}
