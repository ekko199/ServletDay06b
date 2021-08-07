package com.javacto.controller;


import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/queryDogAll.do")
public class DogQueryAll extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //调用业务层代码
        DogService dogService =new DogServiceImpl();
        List list = dogService.queryAll();
        //存值
        req.setAttribute("list",list);
        req.getRequestDispatcher("/dogList.jsp").forward(req,resp);
    }
}
