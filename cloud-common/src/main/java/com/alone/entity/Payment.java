package com.alone.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author alone
 * @date 2020/6/28
 * @desciption Payment
 */
@Data
@NoArgsConstructor
@TableName(value = "payment")
@EqualsAndHashCode(callSuper = true)
public class Payment extends BaseEntity<Payment> implements Serializable {

    @TableField("serial")
    private String serial;
}
