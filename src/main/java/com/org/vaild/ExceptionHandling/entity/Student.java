package com.org.vaild.ExceptionHandling.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @NotNull(message = "fname should not be null")
    @NotBlank(message = "fname should not be blank")
    @NotEmpty(message = "fname should not be empty")
    private String fName;

    @NotNull(message = "lname should not be null")
    @NotBlank(message = "lname should not be blank")
    @NotEmpty(message = "lname should not be empty")
    private String lName;

    @NotNull(message = "mname should not be null")
    @NotBlank(message = "mname should not be blank")
    @NotEmpty(message = "mname should not be empty")
    private String mName;

    @Min(value = 18,message = "student age should be not less than 18")
    @Max(value = 50,message = "student age should be not greater than 50")
    private int age;

    @Email(message = "invalid email id")
    private String email;

    @NotNull(message = "cannot be null")
    @NotBlank(message = "cannot be blank")
    @Pattern(regexp = "^\\d{10}$",message = "invalid phone number")
    private String mobileNumber;
}
