package com.itheima.web.servlet.old;

import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class deleteByIdServlet extends HttpServlet {
    private BrandService brandService=new BrandServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取每一行的JSON数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        brandService.deleteById(Integer.parseInt(params));
        //将JSON数据转换为Brand对象
        System.out.println(params);
        response.getWriter().write("success");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
