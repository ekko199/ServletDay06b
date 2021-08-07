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
@WebServlet("/DogAdd.do")
public class DogAdd extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取值


        String breed=req.getParameter("breed");
        String gender= req.getParameter("gender");

        String price=req.getParameter("price");
        Double price1= Double.parseDouble(price);

        String numbers= req.getParameter("numbers");
        Integer numbers1=Integer.parseInt(numbers);

        //调用业务层代码
        Dog dog=new Dog();
        DogService dogService=new DogServiceImpl();


        dog.setBreed(breed);
        dog.setGender(gender);
        dog.setPrice(price1);
        dog.setNumbers(numbers1);
        int num= dogService.addDog(dog);
        //跳转到查询所有
        req.getRequestDispatcher("/queryDogAll.do").forward(req,resp);
    }
}
