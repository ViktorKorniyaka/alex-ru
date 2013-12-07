<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
<h2>Hello World!</h2>

Hallo from index.jsp :)

<br> <a href="clients.jsp?id=1">Василий Пупкин</a> </br>
<br> <a href="clients.jsp?">Василий Зупкин</a> </br>
<br> <a href="clients.jsp">Василий Дупкин</a> </br>

<details>Покажи, что у тебя есть!</details>



${name}
<h1>${telephone} </h1>
/--------------------
<br>${clientName}
    ${clientTelephone}
</br>
${ls}
${usId}

${client.clientName}
${client.clientTelephone}
<br>/-------------------- <br>

<c:forEach items="${usId}" var="cl">
    <c:out value= " ${cl.clientName}"/>
    <c:out value= " ${cl.clientTelephone}"/>
    <br>
</c:forEach>


<c:forEach var="num" items="${ls}">
<br>${num} </br>
</c:forEach>

<form action="/accaunt" method="post">

    <br>Log:<input type="text" name="log"/>


    <br><input type="submit" name="Go" />

</form>

<%--<c:forEach var="num" items="${usId.items}">

    <tr>
        <td>${num.clientName}</td>
        <td>${num.clientTelephone}</td>
    </tr>

</c:forEach>--%>

 <%--   <c:forEach var="client" items="${usId}">
       &lt;%&ndash; <p>${client}</p>&ndash;%&gt;
        <tr> <td>${client}</td> </tr>
       &lt;%&ndash; <tr> <td>${client.getClientName()}</td> </tr>
        <tr> <td>${client.getClientTelephone()}</td> </tr>
&ndash;%&gt;
    </c:forEach>
--%>


<%--//--------------------------------------------------%>
<%--<jsp:useBean id="usLd" class="java.util.ArrayList" scope="request"/>
<c:forEach items="${usLd}" var="cell">
    ${clientName}
    ${clientTelephone}
    <td align="left">${cell}</td>
</c:forEach>--%>


<%--//------------------------------------------------------
ArrayList listResults= convertToList(set);
request.setAttribute("listResults", listResults);


<jsp:useBean id="listResults" class="java.util.ArrayList" scope="request"/>


<c:forEach items="${listResults}" var="cell">
    <td align="left">${cell.bms}</td>
    <td align="left">${cell.mcc}</td>
    <td align="left">${cell.vendor}</td>
    <td align="center">${cell.handler}</td>
    <td align="center">${cell.maxtemp}</td>
    <td align="left">${cell.phone}</td>
</c:forEach>--%>

    </body>
</html>
