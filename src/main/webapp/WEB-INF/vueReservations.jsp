<%--
  Created by IntelliJ IDEA.
  User: olprog
  Date: 18/08/2023
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Salle réservation</title>
</head>
<body>
<h1>Réservations</h1>

<c:if test="${not empty sessionScope.userSession}">
<p>Bienvenue à toi : ${sessionScope.userSession}</p>
</c:if>

<a href="${pageContext.request.contextPath}/add">Réserver un créneau</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/sign-out">Inscription</a>
<br>
<br>
<table border="1">
  <thead>
  <tr>
    <th>Nom Salle</th>
    <th>Créneau</th>
    <th>Nom Employé</th>
  </tr>
  </thead>
  <tbody>
    <c:forEach items="${reservations}" var="res">
      <tr>
        <td>${res.nomSalle}</td>
        <td>${res.creneau}</td>
        <td>${res.nomEmploye}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
