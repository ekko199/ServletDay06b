<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/9 0009
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        function  checkBreed(breed) {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkBreed.do",
                data: "breed="+breed+"&location=Boston",
                success: function(msg) {
                    var breedErr=document.getElementById("breedErr");
                    if (msg == 0) {
                        breedErr.innerHTML="用户名重复不可以使用该用户名";
                    } else {
                        breedErr.innerHTML="可以使用该用户名";
                    }
                }
            })
        }
        function cccc() {
            var breedErr=document.getElementById("breedErr").innerHTML;
            if (breedErr=='可以使用该用户名'){
                alert("可以使用该用户名")
            }else {
                alert("用户名重复不可以使用该用户名")
                return false;
            }

        }
    </script>
</head>
<body>
     <form action="${pageContext.request.contextPath}/DogAdd.do" method="post" onsubmit="return cccc();">
        品种： <input type="text" name="breed" onblur="checkBreed(this.value)">
         <font id="breedErr"></font>
         性别：<input type="text" name="gender">
        价格: <input type="text" name="price">(价格应低于1000)
        数量: <input type="text" name="numbers">
         <input type="submit" value="添加">
     </form>


</body>
</html>
