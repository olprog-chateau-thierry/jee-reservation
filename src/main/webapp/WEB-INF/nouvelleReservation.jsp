<%--
  Created by IntelliJ IDEA.
  User: olprog
  Date: 18/08/2023
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Nouvelle réservation</h1>
<c:if test="${not empty error}">
    <p style="font-weight: bold; color: darkred; font-size: 1.2rem;">${error}</p>
</c:if>
<form action="${pageContext.request.contextPath}/add" method="post">
    <div>
        <label for="nomSalle">Nom Salle</label>
        <div>
            <select name="nomSalle" id="nomSalle">
                <option disabled selected>Sélectionnez une salle</option>
                <c:forEach items="${nomSalles}" var="nomSalle" varStatus="status">

                    <option value="${status.index}">${nomSalle}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div>
        <label for="creneau">Créneau</label>
        <div>
            <select name="creneau" id="creneau">
                <option disabled selected>Sélectionnez un créneaux</option>
                <c:forEach items="${creneaux}" var="creneau" varStatus="status">
                    <option value="${status.index}">${creneau}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div>
        <label for="nomEmploye">Nom Employé</label>
        <div>
            <input type="text" name="nomEmploye" id="nomEmploye" maxlength="30" minlength="2"
                   value="${reservation.nomEmploye}">
        </div>
    </div>
    <div>
        <button type="submit">Réserver</button>
        <button type="reset">Effacer</button>
    </div>
</form>
</body>
</html>
