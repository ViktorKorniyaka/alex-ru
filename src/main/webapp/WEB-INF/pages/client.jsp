<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.10.13
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
HELLO CLIENT !!!
my name is ${clientName}
<%--id is   ${productId}--%>

<br>info about client and
<br>list of product
<br> <jsp:include page="products.jsp" flush="true"/>   <%-- в сонтройлере попробовать сделать include для  /client/{clientName}/products--%>
<%--<jsp:include url="ProductController.java products.jsp" flush="true"/>--%>
<%--<jsp:directive.include page="/client/{clientName}/products" />--%>
<a href="/client"><input type="button" value="Назад"></a>
</body>
</html>