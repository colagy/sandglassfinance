package cn.js.sandglass.finance.util.exception;

import cn.js.sandglass.finance.util.response.RetResponse;
import cn.js.sandglass.finance.util.response.RetResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RetResult<Object> handle(Exception e) {
        if (e instanceof MyException) {
            MyException myException = (MyException) e;

            return RetResponse.err(myException.getCode(),myException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return RetResponse.err();
        }
    }
}