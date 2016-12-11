package com.shawn.web.exception;

import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Xiaoyue Xiao
 */
@Accessors(chain = true)
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2565431806475335331L;

    private String resourceName;
    private Long id;

    @Override
    public String getMessage() {
        return StringUtils.capitalize(resourceName) + " with id " + id + " is not found.";
    }

}
