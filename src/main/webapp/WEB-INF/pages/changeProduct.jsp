<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.10.13
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
     ------------ Change Product ------------


     <form action="/client/${clientName}/products/${productId}/change" method="post">         <%--// а если тут дать страничку куда надо перейте--%>

         <br>ProductName:<input type="text" name="productName" value="${productName}"/>
         <br>ProductPrice:<input type="text" name="productPrice" value="${productPrice}"/>
         <br>ProductCount:<input type="text" name="productCount" value="${productCount}"/>
         <br>DateBuy:<input type="datetime" name="dateBuy" value="${dateBuy}"/>
         <br>DateEnd:<input type="datetime" name="dateEnd" value="${dateEnd}"/>

         <br><input type="submit" name="Save" value="Сохранить" />
         <input type="button" name="press" value=" Отменить " button onclick='history.back()'> </p>

     </form>
</body>
</html>