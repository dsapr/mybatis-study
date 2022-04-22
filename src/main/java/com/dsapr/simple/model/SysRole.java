package com.dsapr.simple.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private Long id;

    private String roleName;

    private Integer enabled;

    private Long createBy;

    private Date createTime;

    /**
     * 用户信息
     */
    private SysUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}