package com.javacto.controller;

import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkBreed.do")
public class checkBreed extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //处理响映编码格式
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //1,获取请求参数
        String breed = req.getParameter("breed");
        String location=req.getParameter("location");
        //2创建业务层代码
        DogService dogService=new DogServiceImpl();
        //通过用户名查询返回Computer对象也可以 返回boolean也可以
        boolean flag=dogService.findByBreed(breed);
        if (flag){
            out.println("0");
        }else {
            out.println("1");
        }
    }
}
