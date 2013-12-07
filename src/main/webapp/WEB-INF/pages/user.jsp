<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.09.13
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${message}
<br> <a href="/client">Clients</a>
Contacts
Meetings
<br>---------------------------- <br>
Login is:    <h1>${login}</h1>
UserName is: <h1>${userName}</h1>
Email is:    <h1>${email} </h1>

<%--<jsp:directive.include file="newClient.jsp" />--%>  <%-- отправить в контроллер--%>
<td> <a href="/client/add">AddClient</a>  </td>


AddMeeting
AddContact
AddSale
<br> <jsp:include page="listProductAction.jsp" flush="true"/>
<%--Таблица отфильтрованых дат--%>

</body>
</html>