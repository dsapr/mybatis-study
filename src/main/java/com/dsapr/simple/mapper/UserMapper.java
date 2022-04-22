package com.dsapr.simple.mapper;

import com.dsapr.simple.model.SysRole;
import com.dsapr.simple.model.SysUser;

import java.util.List;

/**
 * @author dsapr
 * @date 2022/4/15
 */
public interface UserMapper {
    /**
     * 通过 id 查询用户
     *
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);
}
