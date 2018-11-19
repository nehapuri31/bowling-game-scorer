package com.bowling.app.bowlinggamescorer.exception;

import lombok.Value;


@Value
public class ErrorResponse {

    private String timestamp;
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;

}