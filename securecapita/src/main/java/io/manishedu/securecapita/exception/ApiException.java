package io.manishedu.securecapita.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
