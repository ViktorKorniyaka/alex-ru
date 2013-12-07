<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.10.13
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
Date Today is - ${dateToday} <br>
<br>FormatDate - ${formattedDate}
   <br> ------------ List Products Action by ${userName}------------
<br>List -

<td> <a href="/user/${userName}/list/products-by-date" title="ProductName">Show</a>  </td>
<style>
    table {
        width: 50%; /* Ширина таблицы */
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
    }
    td, th {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 1px solid #000; /* Параметры рамки */
    }
    th {
        background: #afd792; /* Цвет фона */
        color: #333;  /* Цвет текста */
    }
    tbody tr:hover {
        background: #f3bd48; /* Цвет фона при наведении */
        color: #fff; /* Цвет текста при наведении */
    }
</style>

<table style=" border-style: solid; border-width:1px; width: 350px; border-collapse: collapse;"/>
<thead>

</thead>

<table>
    <tr style="background-color: gray;">
        <td style=>ProductName</td>
        <td style=>Price</td>
        <td style=>Count</td>
        <td style=>DateBuy</td>
        <td style=>DateEnd</td>
        <td style=>Id</td>
        <td style=>Do it</td>
        <%--<td style=>Change</td>
        <td style=>Delete</td>--%>
                                       телефон клиента
    </tr>

    <c:forEach items="${listProductsByDate}" var="prod">
        <tr>
            <%-- <a href= "${message}" title="MyClient112">MyClient111</a>
             <td> <a href="/client/{clientName}">${cl.clientName}</a>  </td>--%>
            <td> <a href="product.jsp" title="ProductName">${prod.productName}</a>  </td>
            <td><c:out value= " ${prod.productPrice}"/> </td>
            <td><c:out value= " ${prod.productCount}"/>  </td>
            <td><c:out value= " ${prod.dateBuy}"/>  </td>
            <td><c:out value= " ${prod.dateEnd}"/>  </td>
            <td><c:out value= " ${prod.productId}"/>  </td>
             <td> <a href="/client/${clientName}/products/${prod.productId}/change" title="ProductName">done</a>  </td>
               <%--<td> <a href="/client/${clientName}/products/${prod.productId}/change" title="ProductName">change</a>  </td>
               <td> <a href="/client/${clientName}/products/${prod.productId}/delete" title="ProductName">delete</a>  </td>--%>
        </tr>

    </c:forEach>
</table>
</body>
</html>