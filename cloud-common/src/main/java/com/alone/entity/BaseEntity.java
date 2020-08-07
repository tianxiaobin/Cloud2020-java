package com.alone.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 所有实体继承此实体
 * @author alone
 * @date 2020/6/28
 * @desciption baseEntity
 */
@Data
@Accessors(chain = true)
public class BaseEntity<T> {

    /**
     * 删除标记（0：正常；1：删除）
     */
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";

    @TableId(type = IdType.UUID)
    private String id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime updateDate;

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert() {
        setCreateDate(LocalDateTime.now());
        setUpdateDate( LocalDateTime.now());
    }

    /**
     * 更新之前调用方法
     */
    public void preUpdate(){
        setUpdateDate(LocalDateTime.now());
    }
}
