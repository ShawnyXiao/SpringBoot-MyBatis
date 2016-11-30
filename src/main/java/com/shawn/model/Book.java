package com.shawn.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Xiaoyue Xiao
 */
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book implements Serializable {

    private static final long serialVersionUID = 8604990093149376515L;

    private long id;
    private String name;
    private String author;
    private double price;
    private String topic;
    private Date publishDate;

}
