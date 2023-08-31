package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    //查询所有数据
    @Select("select *from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();



    //添加数据
    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //修改数据
    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void update(Brand brand);


    //根据ID删除数据
    @Delete("delete from tb_brand where id=#{id}")
    void delete(int id);

    //批量删除功能
    void deleteByIds(@Param("ids") int[] ids);

    //查询总条目数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    //分页查询
    @Select("select *from tb_brand limit #{begin},#{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);


    int selectTotalCountAndCondition(Brand brand);

    //分页条件查询
    @ResultMap("brandResultMap")
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size,@Param("brand")Brand brand);
}
