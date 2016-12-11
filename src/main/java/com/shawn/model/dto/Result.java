package com.shawn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Xiaoyue Xiao
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Result implements Serializable {

    private static final long serialVersionUID = -2488668747695124048L;

    private int status;
    private String message;
    private Object data;

}
