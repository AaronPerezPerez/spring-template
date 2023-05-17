package com.springexample.main.api.shared;

import com.springexample.main.app.students.domain.errors.AdultStudentsNotAllowed;
import com.springexample.main.app.students.domain.errors.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class RestExceptionsHandler {
    @ExceptionHandler({AdultStudentsNotAllowed.class})
    public final ResponseEntity<Object> handleException(Exception exception, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", exception.getMessage());

        return new ResponseEntity<>(body, this.mapExceptionToHttpStatus(exception));
    }

    private HttpStatus mapExceptionToHttpStatus(Exception exception) {
        boolean isBadRequestException = exception instanceof AdultStudentsNotAllowed;
        boolean isNotFoundException = exception instanceof StudentNotFound;

        if (isBadRequestException) {
            return HttpStatus.BAD_REQUEST;
        }
        if (isNotFoundException) {
            return HttpStatus.NOT_FOUND;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}