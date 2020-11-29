package com.example.webapp.domain.po;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 */
@TableName("user_info")
public class UserInfo implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField("password")
    private String password;

    /**
     *
     */
    @TableField("remark")
    private String remark;

    /**
     *
     */
    @TableField("username")
    private String username;


    public Integer getId() {
        return this.id;
    }

    public UserInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRemark() {
        return this.remark;
    }

    public UserInfo setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }
}
