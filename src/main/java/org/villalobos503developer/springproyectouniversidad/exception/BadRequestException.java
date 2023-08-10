package org.villalobos503developer.springproyectouniversidad.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
