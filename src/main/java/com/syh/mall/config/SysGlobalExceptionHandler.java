
package com.syh.mall.config;


import com.syh.mall.enums.ErrorCode;
import com.syh.mall.exceptions.BusinessException;
import com.syh.mall.exceptions.VaildEx;
import com.syh.mall.utils.ErrorUtil;
import com.syh.mall.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2021/11/3 11:00
 */
@Slf4j
@RestControllerAdvice
public class SysGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<Object> exceptionGet(Exception e, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Class<? extends Exception> exceClazz = e.getClass();
        if (exceClazz.equals(BusinessException.class)) {
            BusinessException ex = (BusinessException) e;
//			response.setStatus(500);// 抛出500,而不是原本的
            return Result.ofFail((int) ex.getErrCode(), ex.getErrMsg(), ex.getData());
        } else {
            log.info(ErrorUtil.printStackTraceToString(e));
            response.setStatus(500);// 抛出500,而不是原本的
            return Result.ofFail(ErrorCode.ServiceError.getErrorCode(), ErrorCode.ServiceError.getErrorMsg());
        }
    }

    /**
     * MethodArgumentNotValidException异常返回处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseBody
    public Result<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                          HttpServletResponse response) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        VaildEx vex = new VaildEx();
        vex.setErrCount(errors.size());
        errors.stream().map(item -> {
            vex.setErrs(item.getField(), item.getDefaultMessage(), item.getRejectedValue());
            return vex;
        }).collect(Collectors.toList());

        Result<Object> re = Result.ofFail(vex);
        re.setCode(-99);// 检验异常专用code,前端格式需要做调整
        response.setStatus(200);// 抛出200
        return re;
    }

    /**
     * ConstraintViolationException 异常处理(单独的@valided)
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
//	@ResponseBody
    public Result<Object> constraintViolationException(ConstraintViolationException ex, HttpServletResponse response) {
        String msg = ex.getMessage();
        String[] msgs = msg.split(": ");
        response.setStatus(200);// 抛出200
        return Result.ofFail(msgs[msgs.length - 1]);
    }

    /**
     * 文件上传 大小异常处理
     *
     * @param ex
     * @return
     */
//	@ExceptionHandler(MaxUploadSizeExceededException.class)
//	@ResponseBody
//	public Result<Object> maxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
//		return Result.ofFail("文件过大,最大限制为:" + environment.getProperty("spring.servlet.multipart.max-request-size")
//				+ ",单个文件限制为:" + environment.getProperty("spring.servlet.multipart.max-file-size"));
//	}
}
