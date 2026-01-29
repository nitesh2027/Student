package com.example.student.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto {
    private Long id;
  @Size(min=2, max=20, message = "should be 2 or more character")
    private String name;
   @Email(message="Invalid Email id")
    private String email;
   @Size(min=10, max=10, message = "should be 10 digit")
   private String mobile;
    private String message;
}