package com.example.student_management.service;

import com.example.student_management.dtos.requestDto.StudentRequestDto;
import com.example.student_management.dtos.responsedto.StudentResponseDto;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.StudentNotExistException;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto);

    public List<Student> getAllStudents();

    public Optional<Student> getStudentById(Long id) throws StudentNotExistException;

    public StudentResponseDto updateStudent(Long id , StudentRequestDto studentRequestDto) throws StudentNotExistException;


    String deleteStudent(Long id) throws StudentNotExistException;
}
