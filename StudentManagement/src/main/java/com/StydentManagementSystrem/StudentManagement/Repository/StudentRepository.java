package com.StydentManagementSystrem.StudentManagement.Repository;

import com.StydentManagementSystrem.StudentManagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
