package com.shawn.web.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Xiaoyue Xiao
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2565431806475335331L;

    private String object;
    private Long id;

    public ObjectNotFoundException(String object, Long id) {
        super();
        this.object = object;
        this.id = id;
    }

    @Override
    public String getMessage() {
        return StringUtils.capitalize(object) + " with id " + id + " is not found.";
    }
}
