package com.HotelService.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException()
    {
        super("Resource not found on the server");
    }
    public ResourceNotFoundException(String s)
    {
        super(s);
    }
}
