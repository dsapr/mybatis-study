package com.dsapr.simple.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author dsapr
 * @date 2022/4/12
 */
public class CountryMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void init() {
        try {
            // 通过 Resources 工具类将 xml 配置文件读入 Reader
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            // 通过 SqlSessionFactoryBuilder 建造类使用 Reader 建造类使用 Reader 创建 SqlSessionFactory 工厂对象。
            // 首先解析 xml 配置文件，读取配置文件中的 mappers 配置后会读取全部的 Mapper.xml 进行具体方法的解析
            // 解析完成后 SqlSessionFactory 就包含了所有属性配置和执行 SQL 的信息
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException ignore) {
            ignore.printStackTrace();
        }
    }

    @Test
    public void testSelectAll() {
        // 通过工厂对象获取一个 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 通过 SqlSession 的 selectList 方法找到 CountryMapper.xml 中 id="selectAll" 的方法，执行 SQL 查询
            // MyBatis 底层使用 JDBC 执行 SQL，获得查询结果集 ResultSet 后，根据 resultType 的配置将结果映射为 Country 类型的集合，返回查询结果
            List<Country> countryList = sqlSession.selectList("selectAll");
            printCountryList(countryList);
        } finally {
            // 不要忘记关闭 SqlSession，否则会因为连接没有关闭导致数据库连接数过多，造成系统崩溃
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",
                    country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }
}