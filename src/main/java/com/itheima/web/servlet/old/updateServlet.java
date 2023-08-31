package com.itheima.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
          private BrandService brandService=new BrandServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取每一行的JSON数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        //将JSON数据转换为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.update(brand);
        response.getWriter().write("success");
        //request.getRequestDispatcher("/selectAllServlet").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
