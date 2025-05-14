package com.UpwardIq.ChatBotProject.exception;

import com.UpwardIq.ChatBotProject.model.ErrorResponsing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {

        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage(),"user not found") ;

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<?> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage(),"Invalid credentials");
        return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(UserIdExistsException.class)
    public ResponseEntity<?> handleUserIDExistsException(UserIdExistsException ex){
        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage(),"UserId already exists");
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ReceiverListExceptLoggedException.class)
    public ResponseEntity<?> ReceiverListExceptLoggedException(ReceiverListExceptLoggedException ex){
        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage(),"ReceiverList is empty");
        return new ResponseEntity<>(errorResponse,HttpStatus.SERVICE_UNAVAILABLE);
    }



    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {

        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage());

       return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(BlankMessageException.class)
    public ResponseEntity<?> handleBlankMessageException(BlankMessageException ex){
        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage(),"sending blank chat");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoConversationException.class)
    public ResponseEntity<?> handleNoConversation(NoConversationException ex){
        ErrorResponsing errorResponse=new ErrorResponsing(LocalDateTime.now(),ex.getMessage(), "No Past messages between users");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
