package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService=new BrandServiceImpl();
   public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       List<Brand> brands = brandService.selectAll();
       String jsonString = JSON.toJSONString(brands);
       response.setContentType("text/json;charset=utf-8");
       response.getWriter().write(jsonString);
   }

   public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       //获取每一行的JSON数据
       BufferedReader br = request.getReader();
       String params = br.readLine();
       //将JSON数据转换为Brand对象
       Brand brand = JSON.parseObject(params, Brand.class);
       //将Brand对象添加到数据库
       brandService.add(brand);
       response.getWriter().write("success");
   }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取每一行的JSON数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //将JSON数据转换为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.update(brand);
        response.getWriter().write("success");
        //request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取每一行的JSON数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        brandService.deleteById(Integer.parseInt(params));
        //将JSON数据转换为Brand对象
        System.out.println(params);
        response.getWriter().write("success");
    }


    //批量删除操作
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取每一行的JSON数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        int ids[]= JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        //将JSON数据转换为Brand对象
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        BufferedReader br = request.getReader();
        //转为Brand
        String params = br.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
