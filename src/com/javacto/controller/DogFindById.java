package com.javacto.controller;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DogFindById.do")
public class DogFindById extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取id
        String Id =req.getParameter("id");
        Integer id=Integer.parseInt(Id);
        //调用方法
        DogService dogService= new DogServiceImpl();
        Dog dog = dogService.findById(id);
        //存值
        req.setAttribute("dog",dog);
        //跳转到jsp
        req.getRequestDispatcher("/updateDog.jsp").forward(req,resp);


    }
}
