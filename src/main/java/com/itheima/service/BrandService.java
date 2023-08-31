package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    void add(Brand brand);
    void update(Brand brand);
    void deleteById(int id);
    void deleteByIds(int[] ids);

    //begin开始页码，pageSize每页展示条数
    PageBean<Brand> selectByPage(int currentPage, int pageSize);
    //int selectTotalCount();
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);

    //int selectTotalCountAndCondition();
}
