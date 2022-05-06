package com.dsapr.simple.model;

import com.dsapr.simple.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
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

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 创建一个 user 对象
            SysUser user = SysUser.builder()
                    .userName("test1")
                    .userPassword("123456")
                    .userEmail("test@qq.com")
                    .userInfo("test info")
                    // 正常情况下应该读入一张图片存到byte数组中
                    .headImg(new byte[]{1,2,3})
                    .createTime(new Date())
                    .build();
            // 将新建的对象插入到数据库中，特别注意这里的返回值result是执行SQl影响的行数
            int result = userMapper.insert(user);
            // 只插入 1 条数据
            Assert.assertEquals(1, result);
            // id 为 null，没有给 id 赋值，并且没有配置回血 id 的值
            Assert.assertNull(user.getId());
        } finally {
            // 为了不影响其他测试，这里选择回滚
            // 由于默认的sqlSessionFactory.openSession() 是不自动提交的
            // 因此不手动执行 commit 也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
