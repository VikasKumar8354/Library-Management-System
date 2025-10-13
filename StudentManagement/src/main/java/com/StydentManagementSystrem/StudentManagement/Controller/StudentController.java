package com.StydentManagementSystrem.StudentManagement.Controller;

import com.StydentManagementSystrem.StudentManagement.Model.Student;
import com.StydentManagementSystrem.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAll (){
        return studentService.findAll();
    }

    @PutMapping("/update/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student newStudent){
        return studentService.updateStudent(id,newStudent);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
         studentService.deleteStudent(id);
    }
}
