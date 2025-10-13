package com.StydentManagementSystrem.StudentManagement.Service;

import com.StydentManagementSystrem.StudentManagement.Model.Book;
import com.StydentManagementSystrem.StudentManagement.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
}
