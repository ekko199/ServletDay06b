<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/10 0010
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>分页表</title>
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

            <table>
                <tr>
                    <td>
                        总共 ${info.totalPageCount} 页
                        当前第   &nbsp; &nbsp;  ${info.pageNo}       &nbsp; &nbsp; &nbsp;  页
                        总共 &nbsp; &nbsp;  ${info.totalCount}       &nbsp; &nbsp; &nbsp;条数据

                        <c:if test="${info.pageNo>1}">
                            <a href="${pageContext.request.contextPath}/dogPage.do?pageNo=1">首页</a>
                            <a href="${pageContext.request.contextPath}/dogPage.do?pageNo=${info.pageNo-1}">上一页</a>
                        </c:if>
                        <c:if test="${info.pageNo<info.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/dogPage.do?pageNo=${info.pageNo+1}">下一页</a>
                            <a href="${pageContext.request.contextPath}/dogPage.do?pageNo=${info.totalPageCount}">末页</a>}
                        </c:if>
                    </td>
                </tr>

            </table>


</body>
</html>
