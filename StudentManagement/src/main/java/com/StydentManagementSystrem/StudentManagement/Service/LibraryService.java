package com.StydentManagementSystrem.StudentManagement.Service;

import com.StydentManagementSystrem.StudentManagement.Model.Book;
import com.StydentManagementSystrem.StudentManagement.Model.LibraryRecord;
import com.StydentManagementSystrem.StudentManagement.Model.Student;
import com.StydentManagementSystrem.StudentManagement.Repository.BookRepository;
import com.StydentManagementSystrem.StudentManagement.Repository.LibraryRecordRepository;
import com.StydentManagementSystrem.StudentManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private final LibraryRecordRepository libraryRecordRepository;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final BookRepository bookRepository;

    public LibraryService(LibraryRecordRepository libraryRecordRepository,StudentRepository studentRepository,BookRepository bookRepository){
        this.libraryRecordRepository = libraryRecordRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
    }

    public LibraryRecord issueBook(Long studentId, Long bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is not available!");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        book.setAvailable(false);
        bookRepository.save(book);

        LibraryRecord record = new LibraryRecord();
        record.setBook(book);
        record.setStudent(student);
        record.setIssueDate(LocalDate.now());
        record.setReturnDate(LocalDate.now().plusWeeks(2));
        record.setReturned(false);

        return libraryRecordRepository.save(record);
    }

    public LibraryRecord returnBook(Long recordId){
        LibraryRecord record = libraryRecordRepository.findById(recordId).orElseThrow();
        record.setReturned(true);
        record.getBook().setAvailable(true);
        bookRepository.save(record.getBook());
        return libraryRecordRepository.save(record);
    }

    public List<LibraryRecord> getAllRecords(){
        return libraryRecordRepository.findAll();
    }
}
