package com.libraryManagement.lms.service;

import com.libraryManagement.lms.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
        private final List<Book> books = new ArrayList<>();

        public List<Book> getAllBooks(){
            return books;
        }

        public void addBook(Book book){
            books.add(book);
        }

        public boolean borrowBook(String id){
            Optional<Book> bookOptional = books.stream()
                                                        .filter(book -> book.getId().equals(id) && !book.isBorrowed())
                                                        .findFirst();
            if(bookOptional.isPresent()){
                bookOptional.get().setBorrowed(true);
                return true;
            }
            return false;
        }
}
