package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.exception.ResourceNotFound;
import com.example.student.payload.StudentDto;
import com.example.student.repository.StudentRepository;
import org.hibernate.query.SortDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = mapToEntity(studentDto);
        Student savedEntity = studentRepository.save(student);
        StudentDto dto= mapToDto(savedEntity);
        dto.setMessage("Registration saved");
        return dto;
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(long id, StudentDto studentDto) {
        Optional<Student> opStu = studentRepository.findById(id);
                           Student student=opStu.get();

         student.setName(studentDto.getName());
         student.setEmail(studentDto.getEmail());
         student.setMobile(studentDto.getMobile());
            Student savedEntity= studentRepository.save(student);
              StudentDto dto=  mapToDto(student);
                 return dto;
    }



    @Override
    public List<StudentDto> getAllStudents(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(Sort.Direction.ASC, sortBy)
                : Sort.by(Sort.Direction.DESC, sortBy);

        Pageable pageable=PageRequest.of(pageNo,pageSize, sort);
        Page<Student> all = studentRepository.findAll(pageable);
        List<Student> students = all.getContent();
        List<StudentDto> studentDtos = students.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
        System.out.println(all.getTotalPages());
        System.out.println(all.isFirst());
        System.out.println(all.isLast());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize()) ;
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(

                () -> new ResourceNotFound("Registration not found By id:" + id)
         );

        StudentDto studentDto = mapToDto(student);
          return studentDto;
    }


    Student mapToEntity(StudentDto dto) {
        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;
    }

    StudentDto mapToDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setMobile(student.getMobile());
        return dto;
    }
}