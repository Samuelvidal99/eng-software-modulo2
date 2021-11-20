package com.api.engsoftwaremodulo2.exception;

public class AlreadyExistsInDatabaseException extends RuntimeException {
    public AlreadyExistsInDatabaseException(String message) {
        super(message);
    }
}
