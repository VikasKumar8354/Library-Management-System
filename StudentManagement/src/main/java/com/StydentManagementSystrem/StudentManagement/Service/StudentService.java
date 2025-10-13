package com.StydentManagementSystrem.StudentManagement.Service;

import com.StydentManagementSystrem.StudentManagement.Model.Student;
import com.StydentManagementSystrem.StudentManagement.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
     private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

     public Student createStudent(Student student){
         return studentRepository.save(student);
     }

     public Student findById(Long id){
         return studentRepository.findById(id).orElse(null);
     }

     public List<Student> findAll(){
         return studentRepository.findAll();
     }

     public Student updateStudent(Long id,Student newstudent){
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null){
            existingStudent.setName(newstudent.getName());
            existingStudent.setAge(newstudent.getAge());
            existingStudent.setCourse(newstudent.getCourse());
            existingStudent.setRollNo(newstudent.getRollNo());
            return studentRepository.save(existingStudent);
        }
        else {
            return null;
        }
     }

     public void deleteStudent(Long id){
        studentRepository.deleteById(id);
     }
}
