package com.StydentManagementSystrem.StudentManagement.Controller;


import com.StydentManagementSystrem.StudentManagement.Model.LibraryRecord;
import com.StydentManagementSystrem.StudentManagement.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @PostMapping("/issue/{studentId}/{bookId}")
    public LibraryRecord issueBook(@PathVariable Long studentId,@PathVariable Long bookId){
        return libraryService.issueBook(studentId,bookId);
    }

    @PutMapping("/return/{recordId}")
    public LibraryRecord returnBook(@PathVariable Long recordId){
        return libraryService.returnBook(recordId);
    }

    @GetMapping("/getAll")
    public List<LibraryRecord> getAll(){
        return libraryService.getAllRecords();
    }
}
