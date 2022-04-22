package com.dsapr.simple.mapper;

import com.dsapr.simple.model.Country;

import java.util.List;

/**
 * @author dsapr
 * @date 2022/4/16
 */
public interface CountryMapper {
    List<Country> selectAll();
}
