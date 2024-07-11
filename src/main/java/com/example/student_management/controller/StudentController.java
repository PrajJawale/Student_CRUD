package com.example.student_management.controller;

import com.example.student_management.dtos.requestDto.StudentRequestDto;
import com.example.student_management.dtos.responsedto.StudentResponseDto;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.StudentNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.student_management.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) throws StudentNotExistException {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) throws StudentNotExistException {
        return studentService.updateStudent(id, studentRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) throws Exception {
        return studentService.deleteStudent(id);
    }
}
