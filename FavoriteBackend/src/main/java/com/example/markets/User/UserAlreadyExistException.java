package com.example.markets.User;


public class UserAlreadyExistException extends RuntimeException{


    UserAlreadyExistException(String message) {
        super(message);
    }
}
