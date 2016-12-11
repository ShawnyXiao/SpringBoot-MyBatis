package com.shawn.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Xiaoyue Xiao
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedResult extends Result {

    private static final long serialVersionUID = 6191745064790884707L;

    private int currentPage; // Current page number
    private int totalPage; // Number of total pages

    @Override
    public PaginatedResult setStatus(int status) {
        super.setStatus(status);
        return this;
    }

    @Override
    public PaginatedResult setMessage(String message) {
        super.setMessage(message);
        return this;
    }

    @Override
    public PaginatedResult setData(Object data) {
        super.setData(data);
        return this;
    }
}
