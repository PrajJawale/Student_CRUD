package com.example.student_management.exception;

public class StudentNotExistException extends Exception{
    public StudentNotExistException(String message){
        super(message);
    }
}
