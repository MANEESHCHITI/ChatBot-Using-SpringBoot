package com.UpwardIq.ChatBotProject.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String gender;
    private String age;
    private String location;
    private String relocation;
    private String userId;
    private String password;
    

    
}

