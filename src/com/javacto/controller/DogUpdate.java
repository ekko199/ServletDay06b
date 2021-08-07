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
import java.sql.Date;
import java.text.SimpleDateFormat;


@WebServlet("/DogUpdate.do")
public class DogUpdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取值
        String Id =req.getParameter("id");
        Integer id= Integer.parseInt(Id);

        String breed=req.getParameter("breed");
        String gender= req.getParameter("gender");

        String price=req.getParameter("price");
        Double price1= Double.parseDouble(price);

        String birthday=req.getParameter("birthday");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
         Date birthday1= java.sql.Date.valueOf(birthday);


        String numbers= req.getParameter("numbers");
        Integer numbers1=Integer.parseInt(numbers);

        //调用业务层代码
        Dog dog=new Dog();
        DogService dogService=new DogServiceImpl();
        dog.setId(id);
        dog.setBreed(breed);
        dog.setGender(gender);
        dog.setPrice(price1);
        dog.setNumbers(numbers1);
        dog.setBirthday(birthday1);
        int num= dogService.updateDog(dog);
        //跳转到查询所有
        req.getRequestDispatcher("/queryDogAll.do").forward(req,resp);
    }
}
