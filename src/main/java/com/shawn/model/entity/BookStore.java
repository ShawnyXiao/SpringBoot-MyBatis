package com.shawn.model.entity;

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
public class BookStore implements Serializable {

    private static final long serialVersionUID = 1183385713216587274L;

    private long id;
    private String name;
    private String address;

}
