package icu.yuyurbq.go.base.exception;

import icu.yuyurbq.go.base.utils.R;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice(basePackages = "icu.yuyurbq")
@Component
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Throwable.class})
    public R handleException(Throwable throwable) {
        throwable.printStackTrace();
        return R.error(ErrorCodeEnum.UNKNOWN_EXCEPTION.getCode(), ErrorCodeEnum.UNKNOWN_EXCEPTION.getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public R handleValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String,String> map = new HashMap<>();
        result.getFieldErrors().forEach((item)->{
            String message = item.getDefaultMessage();
            String field = item.getField();
            map.put(field,message);
        });
        return R.error(ErrorCodeEnum.VALID_EXCEPTION.getCode(), ErrorCodeEnum.VALID_EXCEPTION.getMessage()).put("data",map);
    }
}
