package com.neusoft.springbootsell.exception;

import com.neusoft.springbootsell.enums.ResultEnum;
import lombok.Getter;

@Getter
public class UserException extends RuntimeException{
    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public UserException(Integer code,String message){
        super(message);
        this.code = code ;
    }
}
