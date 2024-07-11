package com.example.student_management.service.serviceImplementation;


import com.example.student_management.dtos.requestDto.StudentRequestDto;
import com.example.student_management.dtos.responsedto.StudentResponseDto;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.StudentNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import com.example.student_management.transformer.StudentTransFormer;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementaion implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {
        Student student = StudentTransFormer.addStudent(studentRequestDto);
        student = studentRepository.save(student);
        return StudentTransFormer.StudentResponse(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) throws StudentNotExistException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotExistException("Student Not Present with this ID"));
        return Optional.of(student);
    }

    @Override
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) throws StudentNotExistException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotExistException("Student Not Exist with this ID"));
        student = StudentTransFormer.updateStudent(studentRequestDto);
        student.setId(id); // Ensure ID is retained during update
        student = studentRepository.save(student);
        return StudentTransFormer.StudentResponse(student);
    }

    @Override
    public String deleteStudent(Long id) throws StudentNotExistException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotExistException("Student not Exist"));
        studentRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
