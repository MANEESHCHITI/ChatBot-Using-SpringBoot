package com.UpwardIq.ChatBotProject.model;

//import jakarta.persistence.*;
import jakarta.persistence.*;
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
    @Column(nullable = false)
    private String userId;
    private String password;
    

    
}

