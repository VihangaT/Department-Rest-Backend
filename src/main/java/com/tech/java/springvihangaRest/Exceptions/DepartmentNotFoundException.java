package com.tech.java.springvihangaRest.Exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String Message){
        super(Message);
    }
}
