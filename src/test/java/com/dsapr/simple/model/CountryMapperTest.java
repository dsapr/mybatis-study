package com.dsapr.simple.model;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import java.util.List;

/**
 * @author dsapr
 * @date 2022/4/12
 */
public class CountryMapperTest extends BaseMapperTest{

    @Test
    public void testSelectAll() {
        // 通过工厂对象获取一个 SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            // 通过 SqlSession 的 selectList 方法找到 CountryMapper.xml 中 id="selectAll" 的方法，执行 SQL 查询
            // MyBatis 底层使用 JDBC 执行 SQL，获得查询结果集 ResultSet 后，根据 resultType 的配置将结果映射为 Country 类型的集合，返回查询结果
            List<Country> countryList = sqlSession.selectList("com.dsapr.simple.mapper.CountryMapper.selectAll");
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