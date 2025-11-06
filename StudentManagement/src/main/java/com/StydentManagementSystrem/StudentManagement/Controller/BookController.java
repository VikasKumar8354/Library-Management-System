package com.StydentManagementSystrem.StudentManagement.Controller;

import com.StydentManagementSystrem.StudentManagement.Model.Book;
import com.StydentManagementSystrem.StudentManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
//test
public class BookController {

    @Autowired
    private  final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public Book Add (@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/geyById")
    public Book getById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAll(){
        return bookService.getAllBook();
    }
}
