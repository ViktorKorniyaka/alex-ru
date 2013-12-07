<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<body>
        <h1>Message : ${message}</h1>
        <br>TestForm: ${testForm}
      <%--  <a href="${pageContext.request.contextPath}/HelloView.jsp" title="MyClient112">MyClient111</a>--%>
        <a href= "${message}" title="MyClient112">MyClient111</a>       <%-- "MyClient111"--%>

        <a href="/welcome/form" title="form">form</a>
        <br>flashMessage:  <P>${flashMessage}</P>
       <%-- <form action="/welcome" method="post">
              <br>Lol:<input type="text" name="lol"/>
            <br>Lol2:<input type="text" name="lol2"/>
            <br>Lol3:<input type="text" name="lol3"/>
        <br><input type="submit" name="Go" />

        </form>

        <form action="/welcome2" method="post">
            <input type="text" name="name">
            <input type="submit">
        </form>--%>
</body>
</html>