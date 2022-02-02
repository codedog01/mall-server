package com.syh.mall.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author LengAo
 * @date 2021/10/23 15:42
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        /*创建时间*/
        this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
        /*注册时间*/
        this.strictInsertFill(metaObject, "registrationTime", LocalDateTime::now, LocalDateTime.class);
        /*最后登录时间*/
        this.strictUpdateFill(metaObject, "lastLoginTime", LocalDateTime::now, LocalDateTime.class);
        /*上传时间*/
        this.strictInsertFill(metaObject, "uploadTime", LocalDateTime::now, LocalDateTime.class);
        /*更新时间*/
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        /*最后修改密码时间*/
        this.strictInsertFill(metaObject, "lastChgPwdTime", LocalDateTime::now, LocalDateTime.class);

        /*省份*/
        setFieldValByName("province", "地球", metaObject);
        /*围观币*/
        setFieldValByName("loginNum", 0, metaObject);
        /*围观币*/
        setFieldValByName("onlookersCoin", 0, metaObject);
        /*该动态是否重新编辑*/
        setFieldValByName("reEdit", false, metaObject);
        /*点赞量*/
        setFieldValByName("likes", 0, metaObject);
        /*状态*/
        setFieldValByName("state", 1, metaObject);
        /*flag状态*/
        setFieldValByName("stage", 1, metaObject);
        /*个性签命*/
        setFieldValByName("signature", "这个人很懒，什么都没留下~", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
        this.strictUpdateFill(metaObject, "lastLoginTime", LocalDateTime::now, LocalDateTime.class);
    }
}