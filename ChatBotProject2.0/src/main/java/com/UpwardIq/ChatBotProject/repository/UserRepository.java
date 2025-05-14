package com.UpwardIq.ChatBotProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.UpwardIq.ChatBotProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByUserId(String userId);

    User findByUserId(String userId);
    
    
    // Custom query to exclude a specific user
    @Query("SELECT u FROM User u WHERE u.userId <> :userId")
    List<User> findAllByUserIdNot(@Param("userId") String userId);


}




