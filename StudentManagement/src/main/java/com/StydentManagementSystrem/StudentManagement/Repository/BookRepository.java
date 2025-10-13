package com.StydentManagementSystrem.StudentManagement.Repository;

import com.StydentManagementSystrem.StudentManagement.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
