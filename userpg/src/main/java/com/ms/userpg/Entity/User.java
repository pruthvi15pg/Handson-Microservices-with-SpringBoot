package com.ms.userpg.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.Date;
import java.util.Set;


@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Please Provide FirstName")
    private String firstName;

    @NotBlank(message = "Please Provide LastName")
    private String lastName;


    @NotBlank(message = "Please Provide MaidenName")
    private String maidenName;


    @CreatedDate
    private Instant createdDate;
    @CreatedBy
    private String createdBy;

//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
//            message = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character from (@$!%*?&), and be at least 8 characters long")
    private String userPassword;
    private int age;

    @NotBlank(message = "please enter the gender")
    private String gender;

    @Email(message = "please enter the email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$",message = "Invalid Mobile Number Entered")
    private String phone;
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String userName;

    @Past(message = "date should not be present date")
    private Date birthDate;

    private String ip;













}


