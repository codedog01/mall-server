package com.syh.mall.enums;

/**
 * @author LengAo
 * @date 2021/10/17 12:39
 */
public enum Code2SessionErrCode {
    /**
     * 系统繁忙
     */
    SYSTEM_IS_BUSY("系统繁忙，此时请开发者稍候再试", -1),
    /**
     * 请求成功
     */
    SUCCESS("请求成功", 0),
    /**
     * code无效
     */
    CODE_INVALID("code无效", 40029),
    /**
     * 频率限制，每个用户每分钟100次
     */
    FREQUENCY_LIMIT("频率限制，每个用户每分钟100次", 45011),

    /**
     * code已被使用
     */
    CODE_HAS_BEEN_USED("code已被使用",40163),

    /**
     * 高风险等级用户，小程序登录拦截 。风险等级详见用户安全解方案
     */
    LOGIN_INTERCEPTION("高风险等级用户，小程序登录拦截 。风险等级详见用户安全解方案", 40226),

    /**
     * 其他原因
     */
    FAILURE("请求失败", 500);

    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 错误编码
     */
    private int errorCode;

    /**
     * 创建错误码
     */
    private Code2SessionErrCode(String errorMsg, int errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    /**
     * 自定义信息
     * <p>
     * 返回自定义信息和错误预设信息的拼接
     *
     * @param cusMsg 自定义信息
     */
    public String getErrorMsg(String cusMsg) {
        return cusMsg + errorMsg;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @return the errorMsg
     */
    public static Code2SessionErrCode getCode2SessionErrCode(Integer errorCode) {
        if (errorCode!=null) {
            Code2SessionErrCode[] values = Code2SessionErrCode.values();
            for (Code2SessionErrCode value : values) {
                if (value.getErrorCode() == errorCode) {
                    return value;
                }
            }
        }
        return Code2SessionErrCode.FAILURE;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }


    @Override
    public String toString() {
        return this.errorCode + "_" + this.errorMsg;
    }
}
