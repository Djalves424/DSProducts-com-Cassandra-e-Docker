package com.djalves.workshopcassandradocker.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mdg) {
        super(mdg);
    }
}
