<%--
  Created by IntelliJ IDEA.
  User: olprog
  Date: 18/08/2023
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Inscription</h1>

<c:if test="${not empty error}">
  <p>${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/sign-out" method="post">
  <div>
    <label for="nom">Nom</label>
    <div>
      <input type="text" name="nom" id="nom">
    </div>
  </div>
  <div>
    <label for="email">Email</label>
    <div>
      <input type="email" name="email" id="email">
    </div>
  </div>
  <div>
    <label for="pwd">Mot de passe</label>
    <div>
      <input type="text" name="pwd" id="pwd">
    </div>
  </div>
  <div>
    <label for="pwdVerif">Vérification Mot de passe</label>
    <div>
      <input type="text" name="pwdVerif" id="pwdVerif">
    </div>
  </div>
  <div>
    <button type="submit">valider</button>
    <button type="reset">effacer</button>
  </div>
</form>
</body>
</html>
