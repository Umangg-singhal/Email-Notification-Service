package org.email.notification.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.MessagingException;
import java.io.IOException;

@RestControllerAdvice
public class RestExceptionHandler
{
    @ExceptionHandler(value = { IOException.class, MessagingException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(Exception ex)
    {
        return new ErrorResponse(400, "Error in sending email..." + ex);
    }
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse unKnownException(Exception ex)
    {
        return new ErrorResponse(404, "Error in sending email..." + ex);
    }
}