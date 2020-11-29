package com.example.webapp.exception;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.example.webapp.domain.dto.ErrorInfo;
import com.example.webapp.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 通用异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response defaultErrorHandler(Exception e) {
        logger.error("ERROR -> " + e.getMessage());

        //region 空指针异常
        if (e instanceof NullPointerException || e instanceof NoSuchElementException) {
            return new Response<>(MyException.CODE_NULL_ERROR);
        }
        //endregion

        //region 数组越界
        if (e instanceof ArrayIndexOutOfBoundsException) {
            return new Response<>(MyException.CODE_PARAM_NULL);
        }
        //endregion

//        //region 数据库异常
//        if (e instanceof MySQLSyntaxErrorException || e instanceof MyBatisSystemException) {
//            return new Response<>(MyException.CODE_SQL_ERROR);
//        }
        //endregion

        //异常抛出上一级
        Exception cause = (Exception) e.getCause();
        if (cause != null) {
            //region 数据库异常
            //唯一值索引重复或外键关联
//            if (cause instanceof MySQLIntegrityConstraintViolationException) {
//                return new Response<>(MyException.CODE_DATA_REPEAT_ERROR);
//            }
//
//            //数据长度超过数据库长度限制
//            if (cause instanceof MysqlDataTruncation) {
//                return new Response<>(MyException.CODE_DATA_TOO_LONG_ERROR);
//            }

            //SQL错误
            if (cause instanceof MybatisPlusException || cause instanceof SQLException) {
                return new Response<>(MyException.CODE_SQL_ERROR);
            }
            //endregion
        }

        //捕获未知异常
        return new Response<>(MyException.CODE_UNKNOWN_ERROR, e.getMessage());
    }

    /**
     * VO属性校验错误拦截
     *
     * @param error
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Response handleValidException(MethodArgumentNotValidException error) {
        List<FieldError> errors = error.getBindingResult().getFieldErrors();
        List<ErrorInfo> errorInfos = new ArrayList<>();
        for (FieldError err : errors) {
            errorInfos.add(new ErrorInfo(err.getField(), err.getDefaultMessage()));
        }
        return new Response<>(Response.CODE_FAIL, errorInfos);
    }


    /**
     * 自定义异常拦截器
     *
     * @param error
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Response handleBusinessException(MyException error) {
        return new Response<>(error.getErrCode(), error.getErrMsg());
    }
}