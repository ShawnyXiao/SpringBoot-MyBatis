package com.shawn.web.exception;

import com.shawn.model.dto.Result;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Xiaoyue Xiao
 */
@CommonsLog
@ControllerAdvice
class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<?> resourceNotFoundExceptionHandler(HttpServletRequest request, ResourceNotFoundException e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Result()
                        .setStatus(HttpStatus.NOT_FOUND.value())
                        .setMessage(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> exceptionHandler(HttpServletRequest request, Exception e) {
        logError(request, e);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Result()
                        .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .setMessage(e.getMessage()));
    }

    /********************************** HELPER METHOD **********************************/
    private void logError(HttpServletRequest request, Exception e) {
        log.error("\nURI     :   " + request.getRequestURI()
                + "\nerror   :   " + e.getMessage());
    }

}
