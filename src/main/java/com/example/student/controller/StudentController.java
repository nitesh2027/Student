package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.payload.StudentDto;
import com.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController{
     private StudentService studentService;
     public StudentController(StudentService studentService){
         this.studentService=studentService;
     }
    @PostMapping

    public ResponseEntity<?> addStudent(@RequestBody
                                                 @Valid StudentDto studentDto,
                   BindingResult result) {
          if(result.hasErrors()){
              return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.OK);
          }
        StudentDto stuDto = studentService.createStudent(studentDto); // Pass the instance `studentDto` here
        return new ResponseEntity<>(stuDto, HttpStatus.CREATED);
    }
       @DeleteMapping
      public ResponseEntity<String>deleteStudentById(
              @RequestParam long id
       ){
          studentService.deleteStudentById(id);
          return new ResponseEntity<>("Student Deleted", HttpStatus.OK);
       }
       @PutMapping
      public ResponseEntity<StudentDto>updateStudent(
              @RequestParam long id,
               @RequestBody StudentDto studentDto
       ){
          StudentDto dto=
                    studentService.updateStudent(id, studentDto);
          return new ResponseEntity<>(dto, HttpStatus.OK);
       }
       @GetMapping
       public ResponseEntity<List<StudentDto>> getAllStudents(
         @RequestParam(name="pageNo", defaultValue = "0",required = false)int pageNo,
           @RequestParam(name="pageSize", defaultValue = "5",required = false)int pageSize,
       @RequestParam(name="sortBy", defaultValue = "name",required = false)String sortBy,
       @RequestParam(name="sortDir", defaultValue = "name",required = false)String sortDir
       ){
           List<StudentDto> dtos = studentService.getAllStudents(pageNo, pageSize,sortBy,sortDir);
           return new ResponseEntity<>(dtos,HttpStatus.OK);
       }
       @GetMapping("/byId")
      public ResponseEntity<StudentDto>getStudentById(
               @RequestParam long id
       ) {
           StudentDto dto = studentService.getStudentById(id);
               return new ResponseEntity<>(dto, HttpStatus.OK);
           }
       }



