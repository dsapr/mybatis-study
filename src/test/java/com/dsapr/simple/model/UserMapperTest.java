package com.dsapr.simple.model;

import com.dsapr.simple.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author dsapr
 * @date 2022/4/23
 */
public class UserMapperTest extends BaseMapperTest{
    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1l);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            Assert.assertNotNull(userList);
            Assert.assertTrue(userList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            Assert.assertNotNull(roleList);
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
}
