package com.shawn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Xiaoyue Xiao
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorInfo implements Serializable {

    private static final long serialVersionUID = -1259519542613465368L;

    private String url;
    private String message;

}
