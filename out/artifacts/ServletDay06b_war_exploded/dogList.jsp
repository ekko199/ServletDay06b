<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/9 0009
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>狗狗列表</title>
</head>
<body>
    <table border="1" cellspacing="0" cellpadding="0" width="80%">
        <tr>
            <td>id</td>
            <td>breed</td>
            <td>gender</td>
            <td>price</td>
            <td>birthday</td>
            <td>numbers</td>
            <td>操作</td>
            <td>
                <a href="${pageContext.request.contextPath}/addDog.jsp">添加</a>
            </td>
        </tr>
       <c:forEach var="list" items="${list}">
           <tr>
               <td>${list.id}</td>
               <td>${list.breed}</td>
               <td>${list.gender}</td>
               <td>${list.price}</td>
               <td>${list.birthday}</td>
               <td>${list.numbers}</td>
               <td>
                   <a href="${pageContext.request.contextPath}/deleteDog?id=${list.id}">删除</a>
                   <a href="${pageContext.request.contextPath}/DogFindById.do?id=${list.id}">修改</a>
               </td>
           </tr>
       </c:forEach>
    </table>




</body>
</html>
