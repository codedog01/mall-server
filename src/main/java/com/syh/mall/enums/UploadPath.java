package com.syh.mall.enums;

/**
 * <p>description goes here</p>
 *
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
    GOODS_IMG_UPLOAD_PATH("goods/");


    private final String path;

    UploadPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
