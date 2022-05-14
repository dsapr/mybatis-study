package com.dsapr.simple.mapper;
import org.apache.ibatis.annotations.Param;

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

    int insert(SysUser user);

    /**
     * 新增用户-使用 useGeneratedKeys 方式
     */
    int insert2(SysUser sysUser);

    /**
     * 新增用户-使用 selectKey 方式
     */
    int insert3(SysUser sysUser);

    /**
     * 根据主键更新
     */
    int updateById(@Param("updated")SysUser updated,@Param("id")Long id);

    int deleteById(@Param("id")Long id);
}
