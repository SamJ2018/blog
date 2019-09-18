package com.cys.blog.exception.customize;

import lombok.Data;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-18-20:21
 **/
@Data
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
