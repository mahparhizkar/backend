package com.dss.backend.controller;

import com.dss.backend.model.Student;
import com.dss.backend.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/studentApi")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> get() {
        return studentService.get();
    }

    @PostMapping("/student")
    public Student save(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }

    @GetMapping("/student/{id}")
    public Student get(@PathVariable long id) {
        return studentService.get(id);
    }

    @GetMapping("/studentByMeliCode/{melicode}")
    public Student getByMeliCode(@PathVariable String melicode) {
        return studentService.getByMeliCode(melicode);
    }

    @DeleteMapping("/student/{id}")
    public String delete(@PathVariable long id) {
        studentService.delete(id);
        return "Student removed with id "+id;
    }

    @PutMapping("/student")
    public Student update(@RequestBody Student student) {
        studentService.save(student);
        return student;
    }
}