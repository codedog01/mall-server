package com.syh.mall.enums;

/**
 * <p>description goes here</p>
 *
 * @author 冷澳
 * @date 2021/12/26
 */
public enum UploadPath {
    /**
     * 头像上传路径
     */
    AVATAR_UPLOAD_PATH("avatar/"),

    /**
     * 头像上传路径
     */
    DYNAMIC_IMG_UPLOAD_PATH("dynamic/");


    private final String path;

    UploadPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
