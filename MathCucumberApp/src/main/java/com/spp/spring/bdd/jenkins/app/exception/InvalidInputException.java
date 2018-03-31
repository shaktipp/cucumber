package com.spp.spring.bdd.jenkins.app.exception;

public class InvalidInputException extends RuntimeException
{
    public InvalidInputException(String errMessage)
    {
        super(errMessage);
    }
}
