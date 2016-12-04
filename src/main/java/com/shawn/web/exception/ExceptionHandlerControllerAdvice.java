package com.shawn.web.exception;

import com.shawn.model.ErrorInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Greg Turnquist
 */
@CommonsLog
@ControllerAdvice
class ExceptionHandlerControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorInfo objectNotFoundExceptionHandler(HttpServletRequest request, ObjectNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorInfo(request.getRequestURI(), e.getMessage());
    }

}
