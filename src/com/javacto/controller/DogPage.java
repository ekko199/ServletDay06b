package com.javacto.controller;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;
import com.javacto.utils.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/dogPage.do")
public class DogPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                //处理请求编码格式
                req.setCharacterEncoding("UTF-8");
                //处理响映编码格式
                resp.setContentType("text/html;charset=UTF-8");
                //1.获取当前页
                String curNo= req.getParameter("pageNo");
                Integer pageNo=1;
                //这里需要判断curNo是否为空
                if (null!=curNo){
                    //如果不为空则赋值
                    pageNo =Integer.parseInt(curNo);
                }
                //把结果存入PageInfo对象中
                PageInfo infoSbq =new PageInfo();
                infoSbq.setPageNo(pageNo);
                //创建业务层代码
                DogService dogService =new DogServiceImpl();
                List<Dog> list = dogService.pageQueryDog(infoSbq,null);
                int count =dogService.getTotalCount(null);
                //把总条数存入PageInfo 中
                infoSbq.setTotalCount(count);
                //把结果存在于HttpServletRequest中
                req.setAttribute("list",list);
                req.setAttribute("info",infoSbq);
                //跳转
                req.getRequestDispatcher("/dogListPage.jsp").forward(req,resp);

            }
    }
