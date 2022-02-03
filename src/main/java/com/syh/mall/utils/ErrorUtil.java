package com.syh.mall.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @date 2021/11/3 11:00
 */
public class ErrorUtil {

    /**
     * 将异常堆栈信息转换为字符串
     *
     * @param e 异常
     * @return
     */
    public static String printStackTraceToString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        return sw.getBuffer().toString();
    }
}
