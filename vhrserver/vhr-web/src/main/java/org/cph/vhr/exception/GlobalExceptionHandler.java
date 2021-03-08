package org.cph.vhr.exception;

import org.cph.vhr.model.RespBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author cph
 * @create 2020-12-11 15:02
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        log.info("异常信息:" + e.toString());
        if (e instanceof SQLIntegrityConstraintViolationException) {
            return RespBean.error("该数据有关联数据，操作失败");
        }
        return RespBean.error("数据库异常，操作失败");
    }
}
