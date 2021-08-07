<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/9 0009
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改</title>
</head>
<body>
        <form action="${pageContext.request.contextPath}/DogUpdate.do" >
            <input name="id" value="${dog.id}" type="hidden">
            品种：<input name="breed" value="${dog.breed}">
            性别：<input name="gender" value="${dog.gender}">
            价格：<input name="price" value="${dog.price}">(价格应低于1000)
            日期：<input name="birthday" value="${dog.birthday}">
            数量：<input name="numbers" value="${dog.numbers}">
             <br>
            <input type="submit" value="确认修改">


        </form>

</body>
</html>
