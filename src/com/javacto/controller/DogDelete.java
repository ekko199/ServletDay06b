package com.javacto.controller;

import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteDog")
public class DogDelete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取值
        String Id=req.getParameter("id");

        Integer id= Integer.parseInt(Id);
        DogService dogService =new DogServiceImpl();

        int num = dogService.deleteDog(id);
        //跳转到查询所有
        req.getRequestDispatcher("/queryDogAll.do").forward(req,resp);

    }
}
