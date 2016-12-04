package com.shawn.web.exception;

/**
 * @author Xiaoyue Xiao
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -1168987160778410810L;

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
