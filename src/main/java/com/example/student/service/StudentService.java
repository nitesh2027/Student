package com.example.student.service;

import com.example.student.payload.StudentDto;

import java.util.List;

public interface StudentService{
    public StudentDto createStudent(StudentDto studentDto);

    void deleteStudentById(long id);

    StudentDto updateStudent(long id, StudentDto studentDto);

    List<StudentDto> getAllStudents(int pageNo, int pageSize, String sortBy, String sortDir);


    StudentDto getStudentById(long id);
}