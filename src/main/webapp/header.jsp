<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/conducteur-servlet" var="conducteur"></c:url>
<c:url value="/vehicule-servlet" var="vehicule"></c:url>
<c:url value="/association-servlet" var="association"></c:url>

<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active mx-5 text-light" href="${conducteur}">Conducteur</a>
            <a class="nav-item nav-link mx-5 text-light" href="${vehicule}">Vehicule</a>
            <a class="nav-item nav-link mx-5 text-light" href="${association}">Association</a>
        </div>
    </div>
</nav>